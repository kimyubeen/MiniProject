package BookManagement;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class BookManag {
    final private static String pattern1 = "^[0-9]*$";
    private static int memberselect;   // member number
    private static int bookselect;     // book number

    public static void main(String[] args)
            throws ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        BookManag bm = new BookManag();
        
        Scanner sc = new Scanner(System.in);
        
        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        Date returnday = new Date();
        cal.setTime(today);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Borrow> borrowList = new ArrayList<>();

        Member mem = new Member();

        MemberDBBuild(memberList, authList);
        BookDBBuild(bookList, borrowList);

        boolean user_menu = true;
        while (user_menu) {
            // 사용자 선택 메뉴 출력
            int last_num = 1;
            System.out.println("회원을 선택하세요. 회원이 아니시면 회원가입을 해주세요.");
            for (Member m : memberList) {
                System.out.println(" " + m.getId() + ".   " + m.getName());
                last_num++;
            }
            System.out.println(" " + last_num++ + ".   회원가입");
            System.out.println(" " + last_num-- + ".   종료");
            System.out.println();

            int selectmem = sc.nextInt();
            sc.nextLine();

            if (selectmem > last_num || selectmem < 0) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else if (selectmem == (last_num--)) {
                // 회원가입
                System.out.println("추가하고싶은 멤버수를 입력하세요 ");
                int k = sc.nextInt();
                sc.nextLine();
                for (int i = 5; i < k + 5; i++) {
                    Member stu = new Member();
                    stu.setId(i);
                    System.out.println("회원의 이름을 입력하세요 ");
                    String name = sc.nextLine();
                    System.out.println("회원의 생년월일을 입력하세요. 예) 2019년6월24일 => 20190624 ");
                    boolean validation = false;
                    String birth2 = "";
                    while (!validation) {
                        String birth1 = sc.next();
                        validation = birth1.matches(pattern1);
                        if (validation && birth1.length() == 8) {

                            birth2 = birth1;
                        } else {
                            System.out.println("8자리의 숫자만을 입력하세요 .");
                            birth2 = birth1;
                            validation = false;

                        }
                    }
                    Date birth = stringtodate(birth2);

                    System.out.println("등록하고자하는 id를 입력하세요");
                    String id = sc.next();
                    stu.setName(name);
                    stu.setBirth(birth);
                    memberList.add(stu);

                    Auth auth = new Auth();
                    auth.setMemberId(stu.getId());// 1

                    System.out.println("등록하고자하는 pw를 입력하세요");
                    String pw = sc.next();

                    auth.setUserId(id);
                    String pw1 = pw;
                    auth.setPw(convertToSha2(pw1));
                    authList.add(auth);
                }
                sc.nextLine();

            } else { // member menu member selected
                // 로그인
                int login_count = 0;
                selectmem -= 1;
                while(login_count<3) {
                    System.out.println("id를 입력해주세요: ");
                    String id = sc.nextLine();
                    System.out.println("비밀번호를 입력해주세요: ");
                    String pw = sc.nextLine();
                    Member logInUser = new Member();
                    for (Auth a : authList) {
                        if (a.getUserId().equals(id)) {
                            if (pw.equals(a.getPw())) {
                                for (Member s : memberList) {
                                    if (s.getId() == a.getMemberId()) {
                                        logInUser = s;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (logInUser.getName() != null) {
                        bm.memberselect = memberList.get(selectmem).getId();
                       System.out.println("로그인에 성공하셨습니다.");
                       System.out.println("사용자 이름: " + logInUser.getName());
                       boolean exit = false;
                       while(!exit) {
                           // 메뉴 출력
                           System.out.println("------------------------------------------------");
                           System.out.println("   1. 대출     2. 반납     3. 대여 현황  4. 사용자선택  5.종료      ");
                           System.out.println("------------------------------------------------");
                           int selectmenu = sc.nextInt();
                           sc.nextLine();
                           // 대여
                           if (selectmenu == 1) {
                               // 도서 리스트 출력
                               System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                               System.out.printf("%-20s %-35s %-35s %-35s\n", "Rental status", "title", "author", "publisher");
                               System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                               for (Book b : bookList) { //중복되는 값 출력되는 거 수정하기!!!!
                                   for (Borrow brw : borrowList) {
                                       if (b.getBookid() == brw.getBookId()) {
                                           System.out.printf("%2d. %-20s %-35s %-35s %-35s \n", b.getBookid(),
                                                   brw.isStatus() == true ? "대여중" : "대출가능", b.getTitle(), b.getAuthor(),
                                                   b.getPublisher());
                                       }
                                   }
                               }
                               // 도서 선택
                               System.out.println("대여할 책을 선택하세요.");
                               int booknum = sc.nextInt();
                               sc.nextLine();
                               for (Book b : bookList) {
                                   for (Borrow brw : borrowList) {
                                       if(b.getBookid() == booknum) {
                                           if(borrowList.get(booknum - 1).isStatus() == false) {
                                               bm.bookselect = bookList.get(booknum - 1).getBookid();
                                               System.out.println(bookList.get(booknum - 1).getTitle() + "가 대여되었습니다.");
                                               borrowList.get(booknum - 1).setStatus(true);
                                               borrowList.get(booknum - 1).setMemberId(bm.memberselect);
                                               // 대여가능 기간 출력
                                               borrowList.get(booknum - 1).setStartDay(today); 
                                               cal.add(Calendar.DATE, 14);
                                               returnday = cal.getTime();
                                               borrowList.get(booknum - 1).setReturnDay(returnday);
                                               System.out.println("반납할 날짜는 " + sdf.format(returnday) + "입니다.");
                                               break;
                                           }else {
                                               System.out.println(bookList.get(booknum - 1).getTitle() + "은(는) 이미 대여중인 도서입니다.");
                                               break;
                                           }
                                       }
                                       
                                   }
                               }

                           } else if (selectmenu == 2) {
                               // 반납
                               //반납할 도서가 있는지 확인
                               boolean booksForReturn = false;
                               for(Borrow brw : borrowList) {
                                   if(brw.getMemberId() == bm.memberselect) {
                                       booksForReturn = true;
                                       break;
                                   }
                               }
                               if(booksForReturn) { // 반납할 도서가 있다면
                                   System.out.println("< 사용자 대출 도서 리스트 >");
                                   System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                                   System.out.printf("%-15s %-30s %-30s %-30s %-20s %-20s\n", "No.", "title", "author", "publisher", "rentalDate", "returnDate");
                                   System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                                   for(int i = 0; i < borrowList.size(); i++) {
                                       if ((borrowList.get(i).getMemberId() == bm.memberselect)) {
                                           System.out.printf("%2d %-35s %-35s %-35s %-20s %-20s\n", borrowList.get(i).getBookId(), bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPublisher(), sdf.format(borrowList.get(i).getStartDay()), sdf.format(borrowList.get(i).getReturnDay()));
                                       }
                                   }
                                   System.out.println("반납할 도서 번호를 입력하세요.");
                                   int booknum = sc.nextInt();
                                   sc.nextLine();
                                   for (int i = 0; i < borrowList.size(); i++) {
                                       if (borrowList.get(i).getMemberId() == bm.memberselect) {
                                           if ((borrowList.get(i).getBookId() == booknum)) {
                                               System.out.println("반납되었습니다.");
                                               borrowList.get(booknum - 1).setStatus(false);
                                               borrowList.get(booknum - 1).setMemberId(0);
                                               borrowList.get(booknum - 1).setStartDay(null);
                                               borrowList.get(booknum - 1).setReturnDay(null);
                                               
                                           }
                                       }
                                   }
                                   
                               }else { // 반납할 도서가 없다면
                                   System.out.println("반납할 도서가 없습니다.");
                               }
                               
                           }else if (selectmenu == 3) {
                               // 사용자대여현황 리스트 출력
                               System.out.println("< 사용자 대출 도서 리스트 >");
                               System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                               System.out.printf("%-15s %-30s %-30s %-30s %-20s %-20s\n", "No.", "title", "author", "publisher", "rentalDate", "returnDate");
                               System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                               for(int i = 0; i < borrowList.size(); i++) {
                                   if ((borrowList.get(i).getMemberId() == bm.memberselect)) {
                                       System.out.printf("%2d %-35s %-35s %-35s %-20s %-20s\n", borrowList.get(i).getBookId(), bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPublisher(), sdf.format(borrowList.get(i).getStartDay()), sdf.format(borrowList.get(i).getReturnDay()));                             
                                   }
                               }
                           }else if( selectmenu == 4) {
                               System.out.println("사용자 메뉴로 갑니다.");
                               login_count = 3;
                               break;

                           }else {
                               // 종료
                               login_count = 3;
                               break;
                           }
                       
                       } //while(메뉴선택)
                } else {
                        //로그인 실패
                        System.out.println("로그인 실패");
                        login_count += 1;
                        //3회 이상 틀린 경우
                        if (login_count >=3) {
                            System.out.println("사용자 메뉴로 갑니다.");
                            break;
                        }
                    
                }
                    
            }
        }
    }

    System.out.println("프로그램을 종료합니다.");
    //break;
}



    private static void MemberDBBuild(ArrayList<Member> memberList, ArrayList<Auth> authList) throws ParseException {
        
        Member mem = new Member();
        Auth auth = new Auth();
        Date birth = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        Member mem1 = new Member();
        mem1.setId(1);
        mem1.setName("Kim Young Jun");
        birth = sdf.parse("19710130");
        mem1.setBirth(birth);
        memberList.add(mem1);
        
        Auth auth1 = new Auth();
        auth1.setMemberId(1);
        auth1.setUserId("augustine");
        auth1.setPw("young");
        authList.add(auth1);
        
        Member mem2 = new Member();
        mem2.setId(2);
        mem2.setName("Kim Yu Been");
        birth = sdf.parse("19960606");
        mem2.setBirth(birth);
        memberList.add(mem2);
        
        Auth auth2 = new Auth();
        auth2.setMemberId(2);
        auth2.setUserId("yubeenkim");
        auth2.setPw("yubeen");
        authList.add(auth2);
        
        Member mem3 = new Member();
        mem3.setId(3);
        mem3.setName("Lee Yu Jeong");
        birth = sdf.parse("19970505");
        mem3.setBirth(birth);
        memberList.add(mem3);
        
        Auth auth3 = new Auth();
        auth3.setMemberId(3);
        auth3.setUserId("yujeonglee");
        auth3.setPw("yujeong");
        authList.add(auth3);
        
        Member mem4 = new Member();
        mem4.setId(4);
        mem4.setName("Choi Tae Hoon");
        birth = sdf.parse("19980124");
        mem4.setBirth(birth);
        memberList.add(mem4);
        
        Auth auth4 = new Auth();
        auth4.setMemberId(4);
        auth4.setUserId("taehoonchoi");
        auth4.setPw("taehoon");
        authList.add(auth4);

        
//        for (Member m : memberList) {
//            System.out.println(" " + m.getId() + "   " + m.getName() + "  " + m.getBirth());
//        }
//        
//        for (Auth a : authList) {
//            System.out.println(" " + a.getMemberId() + "   " + a.getUserId() + "  " + a.getPw());
//        }
        
    }
    
    private static void BookDBBuild(ArrayList<Book> bookList, ArrayList<Borrow> borrowList) throws ParseException {
        
        Book bk = new Book();
        Borrow br = new Borrow();
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        Book bk1 = new Book();
        bk1.setBookid(1);
        bk1.setTitle("Java Programming");
        bk1.setAuthor("Liang Daniel");
        bk1.setPublisher("Pearson");
        bookList.add(bk1);
        
        Borrow br1 = new Borrow();
        br1.setBookId(1);
        br1.setStatus(true);
        br1.setMemberId(1);
        dt = sdf.parse("20190601");
        br1.setStartDay(dt);
        dt = sdf.parse("20190615");
        br1.setReturnDay(dt);
        borrowList.add(br1);
        
        Book bk2 = new Book();
        bk2.setBookid(2);
        bk2.setTitle("Java Network Programming");
        bk2.setAuthor("Elliotte Rusty");
        bk2.setPublisher("OReilly Media");
        bookList.add(bk2);
        
        Borrow br2 = new Borrow();
        br2.setBookId(2);
        br2.setStatus(true);
        br2.setMemberId(2);
        dt = sdf.parse("20190602");
        br2.setStartDay(dt);
        dt = sdf.parse("20190616");
        br2.setReturnDay(dt);
        borrowList.add(br2);
         
        Book bk3 = new Book();
        bk3.setBookid(3);
        bk3.setTitle("Java Programming");
        bk3.setAuthor("Scott Oaks");
        bk3.setPublisher("OReilly Media");
        bookList.add(bk3);
        
        Borrow br3 = new Borrow();
        br3.setBookId(3);
        br3.setStatus(false);
        //br3.setMemberId(2);
        //dt = sdf.parse("20190602");
        //br2.setStartDay(dt);
        //dt = sdf.parse("20190616");
        //br2.setReturnDay(dt);
        borrowList.add(br3);
        
        Book bk4 = new Book();
        bk4.setBookid(4);
        bk4.setTitle("Harry Potter and the Sorcerer");
        bk4.setAuthor("Mary GrandPre");
        bk4.setPublisher("Scholastic");
        bookList.add(bk4);
        
        Borrow br4 = new Borrow();
        br4.setBookId(4);
        br4.setStatus(true);
        br4.setMemberId(4);
        dt = sdf.parse("20190610");
        br4.setStartDay(dt);
        dt = sdf.parse("20190624");
        br4.setReturnDay(dt);
        borrowList.add(br4);
        
        Book bk5 = new Book();
        bk5.setBookid(5);
        bk5.setTitle("The Silent Patient");
        bk5.setAuthor("Alex Michaelides");
        bk5.setPublisher("Celadon");
        bookList.add(bk5);
        
        Borrow br5 = new Borrow();
        br5.setBookId(5);
        br5.setStatus(true);
        br5.setMemberId(3);
        dt = sdf.parse("20190614");
        br5.setStartDay(dt);
        dt = sdf.parse("20190628");
        br5.setReturnDay(dt);
        borrowList.add(br5);
        
        Book bk6 = new Book();
        bk6.setBookid(6);
        bk6.setTitle("Tuesdays with Morrie");
        bk6.setAuthor("Mitch Albom");
        bk6.setPublisher("Anchor Books");
        bookList.add(bk6);
        
        Borrow br6 = new Borrow();
        br6.setBookId(6);
        br6.setStatus(false);
        //br6.setMemberId(4);
        //dt = sdf.parse("20190610");
        //br6.setStartDay(dt);
        //dt = sdf.parse("20190624");
        //br6.setReturnDay(dt);
        borrowList.add(br6);
        
        Book bk7 = new Book();
        bk7.setBookid(7);
        bk7.setTitle("Basic Grammar In Use");
        bk7.setAuthor("Raymond Murphy");
        bk7.setPublisher("Cambridge");
        bookList.add(bk7);
        
        Borrow br7 = new Borrow();
        br7.setBookId(7);
        br7.setStatus(true);
        br7.setMemberId(1);
        dt = sdf.parse("20190620");
        br7.setStartDay(dt);
        dt = sdf.parse("20190704");
        br7.setReturnDay(dt);
        borrowList.add(br7);
        
        Book bk8 = new Book();
        bk8.setBookid(8);
        bk8.setTitle("Aladdin");
        bk8.setAuthor("Elkizabeth Rubnick");
        bk8.setPublisher("Disney Press");
        bookList.add(bk8);
        
        Borrow br8 = new Borrow();
        br8.setBookId(8);
        br8.setStatus(true);
        br8.setMemberId(2);
        dt = sdf.parse("20190622");
        br8.setStartDay(dt);
        dt = sdf.parse("20190706");
        br8.setReturnDay(dt);
        borrowList.add(br8);
        
        Book bk9 = new Book();
        bk9.setBookid(9);
        bk9.setTitle("Cosmos");
        bk9.setAuthor("Carl Sagan");
        bk9.setPublisher("Ballantine Books");
        bookList.add(bk9);
        
        Borrow br9 = new Borrow();
        br9.setBookId(9);
        br9.setStatus(true);
        br9.setMemberId(1);
        dt = sdf.parse("20190621");
        br9.setStartDay(dt);
        dt = sdf.parse("20190705");
        br9.setReturnDay(dt);
        borrowList.add(br9);
        
        Book bk10 = new Book();
        bk10.setBookid(10);
        bk10.setTitle("How to Draw Almost Everthing");
        bk10.setAuthor("Chika Miyata");
        bk10.setPublisher("Quarry Books");
        bookList.add(bk10);
        
        Borrow br10 = new Borrow();
        br10.setBookId(10);
        br10.setStatus(false);
        //br10.setMemberId(4);
        //dt = sdf.parse("20190610");
        //br10.setStartDay(dt);
        //dt = sdf.parse("20190624");
        //br10.setReturnDay(dt);
        borrowList.add(br10);
        
        Book bk11 = new Book();
        bk11.setBookid(11);
        bk11.setTitle("Homo Deus");
        bk11.setAuthor("Yuval Noah");
        bk11.setPublisher("Vintage");
        bookList.add(bk11);
        
        Borrow br11 = new Borrow();
        br11.setBookId(11);
        br11.setStatus(true);
        br11.setMemberId(4);
        dt = sdf.parse("20190617");
        br11.setStartDay(dt);
        dt = sdf.parse("20190701");
        br11.setReturnDay(dt);
        borrowList.add(br11);
        
        Book bk12 = new Book();
        bk12.setBookid(12);
        bk12.setTitle("Guns, Germs, and Steel");
        bk12.setAuthor("Jared Diamond");
        bk12.setPublisher("Norton & Company");
        bookList.add(bk12);
        
        Borrow br12 = new Borrow();
        br12.setBookId(12);
        br12.setStatus(true);
        br12.setMemberId(4);
        dt = sdf.parse("20190616");
        br12.setStartDay(dt);
        dt = sdf.parse("20190630");
        br12.setReturnDay(dt);
        borrowList.add(br12);
        
        Book bk13 = new Book();
        bk13.setBookid(13);
        bk13.setTitle("Nudge");
        bk13.setAuthor("Richard Thaler");
        bk13.setPublisher("Penguin Books");
        bookList.add(bk13);
        
        Borrow br13 = new Borrow();
        br13.setBookId(13);
        br13.setStatus(false);
        //br13.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br13.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br13.setReturnDay(dt);
        borrowList.add(br13);
        
        Book bk14 = new Book();
        bk14.setBookid(14);
        bk14.setTitle("The Story of Art");
        bk14.setAuthor("E.H. Gombrich");
        bk14.setPublisher("Phaidon Press");
        bookList.add(bk14);
        
        Borrow br14 = new Borrow();
        br14.setBookId(14);
        br14.setStatus(false);
        //br14.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br14.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br14.setReturnDay(dt);
        borrowList.add(br14);
        
        Book bk15 = new Book();
        bk15.setBookid(15);
        bk15.setTitle("The Art of Dishonored");
        bk15.setAuthor("Bethesda Software");
        bk15.setPublisher("Dark Horse Comics");
        bookList.add(bk15);
        
        Borrow br15 = new Borrow();
        br15.setBookId(15);
        br15.setStatus(true);
        br15.setMemberId(3);
        dt = sdf.parse("20190622");
        br15.setStartDay(dt);
        dt = sdf.parse("20190706");
        br15.setReturnDay(dt);
        borrowList.add(br15);
        
        Book bk16 = new Book();
        bk16.setBookid(16);
        bk16.setTitle("Mathematical Analysis");
        bk16.setAuthor("Walter Rudin");
        bk16.setPublisher("McGraw Hill");
        bookList.add(bk16);
        
        Borrow br16 = new Borrow();
        br16.setBookId(16);
        br16.setStatus(false);
        //br16.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br16.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br16.setReturnDay(dt);
        borrowList.add(br16);
        
        Book bk17 = new Book();
        bk17.setBookid(17);
        bk17.setTitle("Botanical Style");
        bk17.setAuthor("Sellina Lake");
        bk17.setPublisher("Peters & Small");
        bookList.add(bk17);
        
        Borrow br17 = new Borrow();
        br17.setBookId(17);
        br17.setStatus(true);
        br17.setMemberId(3);
        dt = sdf.parse("20190620");
        br17.setStartDay(dt);
        dt = sdf.parse("20190704");
        br17.setReturnDay(dt);
        borrowList.add(br17);
        
        Book bk18 = new Book();
        bk18.setBookid(18);
        bk18.setTitle("Justice");
        bk18.setAuthor("Michael Sandel");
        bk18.setPublisher("Farrar Straus");
        bookList.add(bk18);
        
        Borrow br18 = new Borrow();
        br18.setBookId(18);
        br18.setStatus(false);
        //br18.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br18.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br18.setReturnDay(dt);
        borrowList.add(br18);
        
        Book bk19 = new Book();
        bk19.setBookid(19);
        bk19.setTitle("The Conquest of Happiness");
        bk19.setAuthor("Bertrand Russell");
        bk19.setPublisher("Liveright Publishing");
        bookList.add(bk19);
        
        Borrow br19 = new Borrow();
        br19.setBookId(19);
        br19.setStatus(true);
        br19.setMemberId(3);
        dt = sdf.parse("20190621");
        br19.setStartDay(dt);
        dt = sdf.parse("20190705");
        br19.setReturnDay(dt);
        borrowList.add(br19);
        
        Book bk20 = new Book();
        bk20.setBookid(20);
        bk20.setTitle("The Secret of Color");
        bk20.setAuthor("Kassia St Clair");
        bk20.setPublisher("Pengui Books");
        bookList.add(bk20);
        
        Borrow br20 = new Borrow();
        br20.setBookId(20);
        br20.setStatus(false);
        //br20.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br20.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br20.setReturnDay(dt);
        borrowList.add(br20);
        
        Book bk21 = new Book();
        bk21.setBookid(21);
        bk21.setTitle("Outliers");
        bk21.setAuthor("Malcolm Gladwell");
        bk21.setPublisher("Back Bay Books");
        bookList.add(bk21);
        
        Borrow br21 = new Borrow();
        br21.setBookId(21);
        br21.setStatus(true);
        br21.setMemberId(3);
        dt = sdf.parse("20190617");
        br21.setStartDay(dt);
        dt = sdf.parse("20190701");
        br21.setReturnDay(dt);
        borrowList.add(br21);
        
        Book bk22 = new Book();
        bk22.setBookid(22);
        bk22.setTitle("The Tipping Point");
        bk22.setAuthor("Malcolm Gladwell");
        bk22.setPublisher("Back Bay Books");
        bookList.add(bk22);
        
        Borrow br22 = new Borrow();
        br22.setBookId(22);
        br22.setStatus(false);
        //br22.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br22.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br22.setReturnDay(dt);
        borrowList.add(br22);
        
        Book bk23 = new Book();
        bk23.setBookid(23);
        bk23.setTitle("The Sisappearing Spoon");
        bk23.setAuthor("Sam Kean");
        bk23.setPublisher("Back Bay Books");
        bookList.add(bk23);
        
        Borrow br23 = new Borrow();
        br23.setBookId(23);
        br23.setStatus(false);
        //br23.setMemberId(4);
        //dt = sdf.parse("20190617");
        //br23.setStartDay(dt);
        //dt = sdf.parse("20190701");
        //br23.setReturnDay(dt);
        borrowList.add(br23);
        
        Book bk24 = new Book();
        bk24.setBookid(24);
        bk24.setTitle("Treasures of Botanical Art");
        bk24.setAuthor("Shirley Sherwood");
        bk24.setPublisher("Royal Botanic Gardens Kew");
        bookList.add(bk24);
        
        Borrow br24 = new Borrow();
        br24.setBookId(24);
        br24.setStatus(true);
        br24.setMemberId(2);
        dt = sdf.parse("20190611");
        br24.setStartDay(dt);
        dt = sdf.parse("20190625");
        br24.setReturnDay(dt);
        borrowList.add(br24);
        
        Book bk25 = new Book();
        bk25.setBookid(25);
        bk25.setTitle("Coree a Coeur");
        bk25.setAuthor("Ida Daussy");
        bk25.setPublisher("Ateller Des Cahiers");
        bookList.add(bk25);
        
        Borrow br25 = new Borrow();
        br25.setBookId(25);
        br25.setStatus(true);
        br25.setMemberId(4);
        dt = sdf.parse("20190622");
        br25.setStartDay(dt);
        dt = sdf.parse("20190706");
        br25.setReturnDay(dt);
        borrowList.add(br25);
        
        Book bk26 = new Book();
        bk26.setBookid(26);
        bk26.setTitle("Choose the Right Word");
        bk26.setAuthor("Samuel Hayakawa");
        bk26.setPublisher("Harpercollins");
        bookList.add(bk26);
        
        Borrow br26 = new Borrow();
        br26.setBookId(26);
        br26.setStatus(true);
        br26.setMemberId(3);
        dt = sdf.parse("20190621");
        br26.setStartDay(dt);
        dt = sdf.parse("20190705");
        br26.setReturnDay(dt);
        borrowList.add(br26);
        
//        for (Book b : bookList) {
//            System.out.println(" " + b.getBookid() + "   " + b.getTitle() + "  " + b.getAuthor() + "   " + b.getPublisher());
//        }
//        
//        for (Borrow brw : borrowList) {
//            System.out.println(" " + brw.getBookId() + "   " + brw.isStatus() + "  " + brw.getMemberId() + "  " + brw.getStartDay() + "  " + brw.getReturnDay());
//        }
        
        
    }

    private static String convertToSha2(String pw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pw.getBytes("UTF-8"));
        StringBuilder convertedPW = new StringBuilder();
        for (int j : hash) {
            convertedPW.append(String.format("%02x", 0XFF & j));
        }
        return convertedPW.toString();
    }

    private static Date stringtodate(String date) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        String beforechange = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        Date birth = transFormat.parse(beforechange);
        return birth;
    }

}