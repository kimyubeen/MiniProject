package BookManagement;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class BookManag {
    final private static String pattern1 = "^[0-9]*$";
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
    }
    
    public static void main(String[] args)
            throws ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
       
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Borrow> borrowList = new ArrayList<>();

        Member mem = new Member();

        MemberDBBuild(memberList, authList);
        BookDBBuild(bookList, borrowList);
        
        boolean user_menu = true;
        while (user_menu) {
            // 사용자 선택 메뉴
           
            int last_num = 1;
            System.out.println("회원을 선택하세요. 회원이 아니시면 회원가입을 해주세요.");
            // memberName 출력
           
            for (Member m : memberList) {
                System.out.println(" " + m.getId() + ".   " + m.getName());
                last_num++;
            }
            // 회원가입, 종료 출력
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
                    sc.nextLine();
                    System.out.println("이름을 입력하세요 ");
                    String name = sc.nextLine();
                    System.out.println("생일을 입력하세요 ");
                    boolean validation = false;
                    String birth2 = "";
                    sc.nextLine();
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
                    sc.nextLine();
                    String id = sc.next();
                    stu.setName(name);
                    stu.setBirth(birth);
                    memberList.add(stu);

                    Auth auth = new Auth();
                    auth.setMemberId(stu.getId());// 1

                    System.out.println("등록하고자하는 pw를 입력하세요");
                    String pw1 = sc.next();

                    auth.setUserId(id);
                    String pw = pw1;
                    auth.setPw(pw1);
                    authList.add(auth);
                
                 
                }    
                }
                sc.nextLine();
            
            // member menu member selected
                // 로그인
//                int login_count = 0;
//                boolean id_correct = false, pw_correct = false;
//                while(login_count<3 && pw_correct == false) {

//                    for(Member m : memberList) {
//                        if(m.getId() == selectmem) {
//                            System.out.println(m.getName() + "님, ID를 입력하세요.");
//                            String id = sc.nextLine();
//                            for(Auth a : authList) {
//                                if(a.getUserId().equals(id)) {
//                                    
//                                }
//                            }
//                        }
//                    }

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
                       System.out.println("로그인에 성공하셨습니다.");
                        System.out.println("학생 이름: " + logInUser.getName());
                    } else {
                        System.out.println("로그인 실패");
                    }
                    
                    
                    
                   break;
                }//while(로그인 3회오류)

            
           
        } // while(user_menu)

    

    
        
//        for (Member m : memberList) {
//            System.out.println(" " + m.getId() + ".   " + m.getName());
//        }
//        
//        for (Auth a : authList) {
//            System.out.println(" " + a.getMemberId() + "   " + a.getUserId() + "  " + a.getPw());
//        }

    

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
        // br3.setMemberId(2);
        // dt = sdf.parse("20190602");
        // br2.setStartDay(dt);
        // dt = sdf.parse("20190616");
        // br2.setReturnDay(dt);
        borrowList.add(br3);

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