package BookManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BookManag {

    final private static String pattern1 = "^[0-9]*$"; // Only number
    final private static String pattern2 = "^[a-zA-Z0-9]*$"; // alphabet and number
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM YYYY HH:mm:ss z", Locale.US);
    SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a", Locale.US);

    public void init() throws ParseException, InputMismatchException, IOException {

        Scanner sc = new Scanner(System.in);

        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        cal.setTime(today);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Borrow> borrowList = new ArrayList<>();
        
        reader(memberList, authList, bookList, borrowList);
        boolean user_menu = true;

        while (user_menu) {

            // 사용자 선택 메뉴 출력
            int mselect = selectMemberMenu(memberList, sc);

            if (mselect == (memberList.size() + 2)) {
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다. ");
                break;
            } else if (mselect == (memberList.size() + 1)) {
                // 회원가입
                int ask_count1 = 1, ask_count2 = 1;

                while (ask_count1 <= 3) {
                    System.out.println("회원의 이름을 입력하세요.");
                    String name = sc.nextLine();

                    System.out.println("회원의 생년월일을 예제와 같이 숫자로 입력하세요. 예) 2019년6월24일 => 20190624 ");
                    String birth = sc.nextLine();

                    if ((birth.matches(pattern1)) && (birth.length() == 8)
                            && (registerMember(memberList, name, birth))) {
                        // True : register
                        Member mb = new Member();
                        mb.setId(memberList.size() + 1);
                        mb.setName(name);
                        mb.setBirth(sdf.parse(birth));
                        while (ask_count2 <= 3) {
                            // ID 와 PW 입력
                            System.out.println("회원의 ID를 입력하세요. (알파벳 대소문자와 숫자만 허용함)");
                            String id = sc.nextLine();

                            System.out.println("회원의 PW를 입력하세요. (알파벳 대소문자와 숫자만 허용함)");
                            String pw = sc.nextLine();
                            if (registerAuth(authList, id, pw)) {
                                // 회원 가입
                                memberList.add(mb);
                                Auth at = new Auth();
                                at.setMemberId(authList.size() + 1);
                                at.setUserId(id);
                                at.setPw(pw);
                                authList.add(at);
                                ask_count1 = 4;
                                ask_count2 = 4;
                            } else if (ask_count2 == 3) {
                                ask_count2 += 1;
                                ask_count1 = 4;
                                System.out.println("3번 입력 오류로 인해 사용자 메뉴로 갑니다.");
                                break;
                            } else {
                                System.out.println(ask_count2 + "번 ID 또는 PW을 잘못 입력하셨습니다.");
                                ask_count2 += 1;
                            }
                        }
                    } else if (ask_count1 == 3) {
                        ask_count1 += 1;
                        System.out.println("3번 입력 오류로 인해 사용자 메뉴로 갑니다.");
                        break;
                    } else {
                        System.out.println(ask_count1 + "번 이름 또는 생년월일을 잘못 입력하셨습니다.");
                        ask_count1 += 1;
                    }
                } // while

            } else { // member menu member selected
                // 로그인
                int login_count = 1;
                boolean login = false;
                while (login_count <= 3) {
                    // ID 와 PW 입력
                    System.out.println("회원의 ID를 입력하세요.");
                    String id = sc.nextLine();

                    System.out.println("회원의 PW를 입력하세요.");
                    String pw = sc.nextLine();

                    if (checkAuth(authList, id, pw, mselect - 1)) {
                        login = true;
                        mselect = indexAuth(authList, id, pw);
                        System.out.println("로그인 하였습니다.");
                        login_count = 4;
                    } else if (login_count == 3) {
                        login_count += 1;
                        System.out.println("3번 입력 오류로 인해 사용자 메뉴로 갑니다.");
                        break;
                    } else {
                        System.out.println(login_count + "번 ID 또는 PW을 잘못 입력하셨습니다.");
                        login_count += 1;
                    }
                } // while

                while (login) {
                    // 메뉴 출력
                    System.out.println("-------------------------------------------");
                    System.out.println("   1. 대출     2. 반납     3. 대여 현황  4. 로그아웃");
                    System.out.println("-------------------------------------------");
                    String selectMenu = sc.nextLine();
                    if(selectMenu.matches(pattern1)) {
                        int selectmenu = Integer.parseInt(selectMenu);
                        // 대여
                        if (selectmenu == 1) {
                            // 도서 리스트 출력
                            if (checkbookRental(mselect, borrowList)) {
                            
                            bookRental(mselect, memberList, bookList, borrowList, sc);
                            }else {
                                System.out.println("대여한 책이 많습니다. 반납하시고 대여하세요.");
                            }
                        } else if (selectmenu == 2) {
                            // 반납
                            bookReturn(mselect, memberList, bookList, borrowList, sc);
                        } else if (selectmenu == 3) {
                            // 사용자대여현황 리스트 출력
                            memberRentalList(mselect, memberList, bookList, borrowList, sc);
                        } else if (selectmenu == 4) {
                            login = false;
                            login_count = 4;
                        } else {
                            System.out.println("다시 입력하세요.");
                            login = true;
                        }
                    }else {
                        System.out.println("다시 입력하세요.");
                    }

                } // while(Login)
            }
        }
        write(memberList, authList, bookList, borrowList);
    }

    private boolean checkbookRental(int select, ArrayList<Borrow> borrowList) {
        int bookcount = 0;

        for (Borrow br : borrowList) {
            if (br.getMemberId() == select) {
                if (br.isStatus()) {
                    bookcount++;
                } else {
                    bookcount--;
                }
            }

        }

        if (bookcount >= 5) {
            return false;
        } else {
            return true;
        }
    }

    private void reader(ArrayList<Member> memberList, ArrayList<Auth> authList, ArrayList<Book> bookList, ArrayList<Borrow> borrowList) throws IOException, ParseException {
            String temp1 = "";
            String reader1 = "";
            BufferedReader bReader1 = new BufferedReader(new FileReader("book.txt"));
            while ((temp1 = bReader1.readLine()) != null) {
                reader1 += temp1 + "\n";
            }
    
            JsonParser p = new JsonParser();
            JsonElement element = p.parse(reader1);
    
            JsonArray jArray = element.getAsJsonArray();
            for (JsonElement e : jArray) {
                JsonObject o = e.getAsJsonObject();
                Book b = new Book();
                b.setBookid(o.get("bookid").getAsInt());
                b.setTitle(o.get("title").getAsString());
                b.setAuthor(o.get("author").getAsString());
                b.setPublisher(o.get("publisher").getAsString());
    
                bookList.add(b);
    
            }
            String temp2 = "";
            String reader2 = "";
            bReader1 = new BufferedReader(new FileReader("borrow.txt"));
            while ((temp2 = bReader1.readLine()) != null) {
                reader2 += temp2 + "\n";
            }
    
            JsonParser p2 = new JsonParser();
            JsonElement element2 = p2.parse(reader2);
            JsonArray jArray2 = element2.getAsJsonArray();
            for (JsonElement e1 : jArray2) {
                JsonObject o1 = e1.getAsJsonObject();
                Borrow b2 = new Borrow();
                b2.setBookId(o1.get("bookId").getAsInt());
                b2.setStatus(o1.get("status").getAsBoolean());
                b2.setMemberId(o1.get("memberId").getAsInt());
                
                String o4 = "";
                String o3 = "";
                
                if ((o1.get("startDay")) != null) {
                    o4 = o1.get("startDay").getAsString();
                    b2.setStartDay(sdf3.parse(o4));
                    o3 = o1.get("returnDay").getAsString();
                    b2.setReturnDay(sdf3.parse(o3));
    
                } else {
                    Date o5 = null;
                    //Date o6 = null;
                    b2.setStartDay(o5);
                    b2.setReturnDay(o5);
    
                }
    
                borrowList.add(b2);
            }
                String temp3 = "";
                String reader3 = "";
                bReader1 = new BufferedReader(new FileReader("member.txt"));
                while ((temp3 = bReader1.readLine()) != null) {
                    reader3 += temp3 + "\n";
                }
    
                JsonParser p3 = new JsonParser();
                JsonElement element3 = p3.parse(reader3);
                
                JsonArray jArray3 = element3.getAsJsonArray();
                for (JsonElement e3 : jArray3) {
                   
                    
                    JsonObject o2 = e3.getAsJsonObject();
                    Member m1 = new Member();
                    m1.setId(o2.get("id").getAsInt());
                    m1.setName(o2.get("name").getAsString());
                    String o6= "";
                    o6 = o2.get("birth").getAsString();
                    m1.setBirth(sdf3.parse(o6));
                    memberList.add(m1);
                    
                }
                String temp4 = "";
                String reader4 = "";
                bReader1 = new BufferedReader(new FileReader("auth.txt"));
                while ((temp4 = bReader1.readLine()) != null) {
                    reader4 += temp4 + "\n";
                }
    
                JsonParser p4 = new JsonParser();
                JsonElement element4 = p4.parse(reader4);
    
                JsonArray jArray4 = element4.getAsJsonArray();
                for (JsonElement e4 : jArray4) {
                    JsonObject o31 = e4.getAsJsonObject();
                    Auth a1 = new Auth();
                    a1.setMemberId(o31.get("memberId").getAsInt());
                    a1.setPw(o31.get("pw").getAsString());
                    a1.setUserId(o31.get("userId").getAsString());
                    authList.add(a1);
                
            }

    }
    
    private void write(ArrayList<Member> memberList, ArrayList<Auth> authList, ArrayList<Book> bookList,
            ArrayList<Borrow> borrowList) throws IOException {
        String booklist = bookList.toString();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter("book.txt"));
        
        bWriter.write(booklist.toString());
        bWriter.close();
        
        String borrowlist = borrowList.toString();
        BufferedWriter bWriter2 = new BufferedWriter(new FileWriter("borrow.txt"));
        
        bWriter2.write(borrowlist.toString());
        bWriter2.close();
        
        String memberlist = memberList.toString();
        BufferedWriter bWriter3 = new BufferedWriter(new FileWriter("member.txt"));
        
        bWriter3.write(memberlist.toString());
        bWriter3.close();
        
        String authlist = authList.toString();
        BufferedWriter bWriter4 = new BufferedWriter(new FileWriter("auth.txt"));
        
        bWriter4.write(authlist.toString());
        bWriter4.close();
        
    }

    private static int selectMemberMenu(ArrayList<Member> memberList, Scanner sc) throws InputMismatchException {

        int iselect = 0;
        String select = "";
 
        do {
            System.out.println("아래와 같이 회원을 선택하거나 회원가입 또는 종료를 선택하기 위해 번호를 입력하세요.");

            for (Member m : memberList) {
                System.out.println(" " + m.getId() + ".   " + m.getName());
            }

            System.out.println(" " + (memberList.size() + 1) + ".   회원가입");
            System.out.println(" " + (memberList.size() + 2) + ".   종료");
            select = sc.nextLine();
        } while ((!select.matches(pattern1)) || (Integer.parseInt(select) > (memberList.size() + 2)));

        iselect = Integer.parseInt(select);

        return iselect;
    }

    private static boolean registerMember(ArrayList<Member> memberList, String name, String birth)
            throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String st = birth.substring(0, 4);
        int year = Integer.parseInt(st);
        st = birth.substring(4, 6);
        int month = Integer.parseInt(st);
        st = birth.substring(6, 8);
        int day = Integer.parseInt(st);
        // System.out.println(year + " " + month + " " + day);

        for (Member mbr : memberList) {
            if ((mbr.getName()).equals(name) && sdf.format(mbr.getBirth()).equals(birth)) {
                System.out.println("기존에 등록된 회원입니다.");
                return false;
            }
        }
        if ((name.length() > 0) && (birth.matches(pattern1)) && (birth.length() == 8) && (year >= 1920)
                && (year <= 2019) && (month >= 1) && (month <= 12) && (day >= 1) && (day <= 31)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean registerAuth(ArrayList<Auth> authList, String id, String pw) {

        for (Auth atl : authList) {
            if (atl.getUserId().equals(id)) {
                System.out.println("기존에 등록된 ID 입니다.");
                return false;
            }
        }
        if ((pw.length() > 0) && (pw.matches(pattern2)) && (id.length() > 0) && (id.matches(pattern2))) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkAuth(ArrayList<Auth> authList, String id, String pw, int mselect) {

        boolean check = false;

        if ((authList.get(mselect).getUserId().contentEquals(id))
                && (authList.get(mselect).getPw().contentEquals(pw))) {
            check = true;
        }

        return check;
    }

    private static int indexAuth(ArrayList<Auth> authList, String id, String pw) {

        for (Auth atl : authList) {
            if ((atl.getUserId().equals(id)) && (atl.getPw().equals(pw))) {
                // System.out.println("기존에 등록된 회원입니다. "+ atl.getMemberId());
                return atl.getMemberId();
            }
        }
        return 0;
    }

    // 대여 메소드
    private static void bookRental(int member, ArrayList<Member> memberList, ArrayList<Book> bookList, ArrayList<Borrow> borrowList, Scanner sc) {
        // 도서 리스트 출력
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("   " + "rental status" + "\t" + "title" + "\t\t\t\t" + "author" + "\t\t\t\t" + "publisher");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------");
        boolean isRental = true;
        int exitButton = bookList.size() + 1;
        for (Book b : bookList) {
            for (Borrow brw : borrowList) {
                if (b.getBookid() == brw.getBookId()) {
                    if (brw.isStatus() == true) {
                        isRental = false;
                    } else {
                        isRental = true;
                    }
                }
            }
            System.out.printf("%2d. %-20s %-35s %-35s %-35s \n", b.getBookid(), (isRental == false ? "대여중" : "대출가능"),
                    b.getTitle(), b.getAuthor(), b.getPublisher());
        }
        System.out.println(exitButton + ". exit");

        boolean rentalRepeat = true;
        do {

            // 도서 선택
            System.out.println("대여할 책을 선택하세요.");
            String stringBookNum = sc.nextLine();

            //int bookSize = bookList.size();
            if (stringBookNum.matches(pattern1)) {
                int booknum = Integer.parseInt(stringBookNum);
                if (booknum >= exitButton) {
                    rentalRepeat = false;
                    break;

                } else {
                    for (Book b : bookList) {
                        //for (Borrow brw : borrowList) {
                            if (b.getBookid() == booknum) {
                                if (borrowList.get(booknum - 1).isStatus() == false) {
                                   
                                    // 대여가능 기간 출력
                                    Calendar cal = new GregorianCalendar();
                                    Date today = new Date();
                                    Date returnday = new Date();
                                    cal.setTime(today);
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
                                    borrowList.get(booknum - 1).setStartDay(today);
                                    cal.add(Calendar.DATE, 14);
                                    returnday = cal.getTime();

                                    Borrow br = new Borrow();
                                    br.setBookId(booknum);
                                    br.setMemberId(member);
                                    br.setStartDay(today);
                                    br.setReturnDay(returnday);
                                    br.setStatus(true);
                                    borrowList.add(br);

                                    System.out.println(bookList.get(booknum - 1).getTitle() + "가 대여되었습니다.");
                                    System.out.println("반납할 날짜는 " + sdf.format(returnday) + "입니다.");

                                    rentalRepeat = false;
                                    break;

                                } else {
                                    System.out.println(bookList.get(booknum - 1).getTitle() + "은(는) 이미 대여중인 도서입니다.");
                                    rentalRepeat = true;
                                    break;
                                }
                            } 
                        //}  // for
                    }
                }
            }
        } while (rentalRepeat);
        
    }

    // 반납 메소드
    private static void bookReturn(int member, ArrayList<Member> memberList, ArrayList<Book> bookList,
            ArrayList<Borrow> borrowList, Scanner sc) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        boolean returnRepeat = true;
        boolean booksForReturn = false;


        ArrayList<Borrow> tborrowList = new ArrayList<>();

        for (Borrow brw : borrowList) {
            if ((brw.getMemberId() == member) && (brw.isStatus())) {
                boolean add_list = true;
                int index = borrowList.indexOf(brw);
                // Borrow tbr = borrowList.get(index);
                for (int i = index; i < borrowList.size(); i++) {
                    // System.out.println(i + " " + borrowList.get(i).getMemberId() + " " +
                    // borrowList.get(i).getBookId());
                    if ((borrowList.get(i).getMemberId() == member) && (!borrowList.get(i).isStatus())
                            && (borrowList.get(i).getBookId() == brw.getBookId())) {
                        add_list = false;
                    }
                }
                if (add_list) {
                    // System.out.println("add " + br.getMemberId() + " " + br.getBookId());
                    tborrowList.add(brw);
                }
            }
        }
        
        if (tborrowList.size() > 0 ) {
            booksForReturn = true;
        }
        if (booksForReturn) { // 반납할 도서가 있다면
            memberRentalList(member, memberList, bookList, borrowList, sc);
            while (returnRepeat) {
                System.out.println("반납할 도서 번호를 입력하세요.");
                String stringBookNum = sc.nextLine();
                
                if(stringBookNum.matches(pattern1)) {
                    int booknum = Integer.parseInt(stringBookNum);
                    for (int i = 0; i < borrowList.size(); i++) {
                        if (borrowList.get(i).getMemberId() == member) {
                            if (borrowList.get(i).getBookId() == booknum) {
                                if (borrowList.get(i).isStatus() == true) {
    
                                    // 대여가능 기간 출력
                                    Calendar cal = new GregorianCalendar();
                                    Date today = new Date();
                                    //Date returnday = new Date();
                                    cal.setTime(today);
                                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
                                    //borrowList.get(booknum - 1).setStartDay(today);
                                    //cal.add(Calendar.DATE, 14);
                                    today = cal.getTime();
                                    
                                    Borrow br = new Borrow();
                                    br.setBookId(booknum);
                                    br.setMemberId(member);
                                    //br.setStartDay(today);
                                    br.setReturnDay(today);
                                    br.setStatus(false);
                                    borrowList.add(br);
                                    
                                    
//                                    borrowList.get(booknum - 1).setStatus(false);
//                                    borrowList.get(booknum - 1).setMemberId(0);
//                                    borrowList.get(booknum - 1).setStartDay(null);
//                                    borrowList.get(booknum - 1).setReturnDay(null);
                                    System.out.println("반납되었습니다.");
                                    returnRepeat = false;
                                    break;
                                } else {
                                    System.out.println("대여중인 도서가 아닙니다.");
                                    break;
    
                                }
                            }
                        }
    
                    }
                }else {
                    System.out.print("잘못입력하셨습니다. ");
                    returnRepeat = true;
                }
            }

        } else { // 반납할 도서가 없다면
            System.out.println("반납할 도서가 없습니다.");
        }

    }

    // 사용자 대여현황 리스트 메소드
    private static void memberRentalList(int member, ArrayList<Member> memberList, ArrayList<Book> bookList,
            ArrayList<Borrow> borrowList, Scanner sc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        // 사용자대여현황 리스트 출력
        System.out.println("< " + memberList.get(member-1).getName() + "님  대출 도서 리스트 >");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("BookNum" + "\t\t" + "title" + "\t\t\t\t" + "author" + "\t\t\t\t" + "publisher" + "\t\t\t" + "rentalDate" + "\t" + "returnDate");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------");
        
        ArrayList<Borrow> tborrowList = new ArrayList<>();
                
        for (Borrow br : borrowList) {
            if ((br.getMemberId() == member) && (br.isStatus())) {
                boolean add_list = true;
                int index = borrowList.indexOf(br);
                for (int i = index; i < borrowList.size(); i++) {
                    if ((borrowList.get(i).getMemberId() == member) && (!borrowList.get(i).isStatus()) && (borrowList.get(i).getBookId() == br.getBookId())) {
                        add_list = false;
                    }
                }
                if (add_list) {
                    tborrowList.add(br);
                }
            }
        }
        
       
        for (Borrow tbr : tborrowList) {
            System.out.printf("%2d %-35s %-35s %-35s %-15s %-15s\n", tbr.getBookId(), bookList.get(tbr.getBookId()-1).getTitle(), bookList.get(tbr.getBookId()-1).getAuthor(),
                            bookList.get(tbr.getBookId()-1).getPublisher(),
                            sdf.format(tbr.getStartDay()), sdf.format(tbr.getReturnDay()));
            
            
        }
    }

}