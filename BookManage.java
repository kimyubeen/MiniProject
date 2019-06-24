import java.util.*;
import java.text.*;

public class BookManage {

    private static String memberselect;   // member number
    private static String bookselect;     // book number
    
    public static void main(String[] args) {
        
        BookManage bm = new BookManage();
        
        // member data
        String memberArr[][] = new String[10][5];
        memberArr[0][0] = "0000001";        // memberNumber
        memberArr[0][1] = "Kim Young Jun";  // memberName
        memberArr[0][2] = "augustine";      // id
        memberArr[0][3] = "young";          // pw
        memberArr[0][4] = "19710130";       // birth
        
        memberArr[1][0] = "0000002";
        memberArr[1][1] = "Kim Yu Bin";
        memberArr[1][2] = "yubinkim";
        memberArr[1][3] = "yubin";
        memberArr[1][4] = "19970505";
        
        memberArr[2][0] = "0000003";
        memberArr[2][1] = "Lee Yu Jeong";
        memberArr[2][2] = "yujeonglee";
        memberArr[2][3] = "yujeong";
        memberArr[2][4] = "19980606";
        
        memberArr[3][0] = "0000004";
        memberArr[3][1] = "Choi Tae Hoon";
        memberArr[3][2] = "taehoon";
        memberArr[3][3] = "tae123";
        memberArr[3][4] = "19991001";
        
        // book data
        String bookArr[][] = new String[30][9];
        bookArr[0][0] = "0000001";                      // BookNumber
        bookArr[0][1] = "Science";                      // Category (Humanities, Society, Science, Art)
        bookArr[0][2] = "Java Programming";             // Title
        bookArr[0][3] = "Liang Daniel";                 // Author
        bookArr[0][4] = "Pearson";                      // Publisher
        bookArr[0][5] = "true";                         // Rental Status true(대여됨, 대여불가능), false(대여않됨, 대여가능)
        bookArr[0][6] = "0000001";                      // Member
        bookArr[0][7] = "20190601";                     // Start Date
        bookArr[0][8] = "20190615";                     // End Date

        bookArr[1][0] = "0000002";
        bookArr[1][1] = "Science";
        bookArr[1][2] = "Java Network Programming";   
        bookArr[1][3] = "Elliotte Rusty";               
        bookArr[1][4] = "OReilly Media";           
        bookArr[1][5] = "true";                 
        bookArr[1][6] = "0000002";
        bookArr[1][7] = "20190602";               
        bookArr[1][8] = "20190616";              

        bookArr[2][0] = "0000003";               
        bookArr[2][1] = "Science";
        bookArr[2][2] = "Java Programming"; 
        bookArr[2][3] = "Scott Oaks";              
        bookArr[2][4] = "OReilly Media";          
        bookArr[2][5] = "false";
        bookArr[2][6] = "";          
        bookArr[2][7] = "";               
        bookArr[2][8] = "";             

        bookArr[3][0] = "0000004";               
        bookArr[3][1] = "Humanities";
        bookArr[3][2] = "Harry Potter and the Sorcerer";  
        bookArr[3][3] = "Mary GrandPre";             
        bookArr[3][4] = "Scholastic";         
        bookArr[3][5] = "true";
        bookArr[3][6] = "0000004";           
        bookArr[3][7] = "20190610";              
        bookArr[3][8] = "20190624";               

        bookArr[4][0] = "0000005";                
        bookArr[4][1] = "Society";
        bookArr[4][2] = "The Silent Patient";  
        bookArr[4][3] = "Alex Michaelides";             
        bookArr[4][4] = "Celadon";         
        bookArr[4][5] = "true";
        bookArr[4][6] = "0000003";          
        bookArr[4][7] = "20190614";                
        bookArr[4][8] = "20190628";              

        bookArr[5][0] = "0000006";
        bookArr[5][1] = "Humanities";
        bookArr[5][2] = "Tuesdays with Morrie";
        bookArr[5][3] = "Mitch Albom";
        bookArr[5][4] = "Anchor Books";
        bookArr[5][5] = "false";
        bookArr[5][6] = "";
        bookArr[5][7] = "";
        bookArr[5][8] = "";

        bookArr[6][0] = "0000007";
        bookArr[6][1] = "Society";
        bookArr[6][2] = "Basic Grammar In Use";
        bookArr[6][3] = "Raymond Murphy";
        bookArr[6][4] = "Cambridge";
        bookArr[6][5] = "true";
        bookArr[6][6] = "0000001";
        bookArr[6][7] = "20190620";
        bookArr[6][8] = "20190704";

        bookArr[7][0] = "0000008";
        bookArr[7][1] = "Art";
        bookArr[7][2] = "Aladdin";
        bookArr[7][3] = "Elkizabeth Rubnick";
        bookArr[7][4] = "Disney Press";
        bookArr[7][5] = "true";
        bookArr[7][6] = "0000002";
        bookArr[7][7] = "20190622";
        bookArr[7][8] = "20190706";
        
        bookArr[8][0] = "0000009";
        bookArr[8][1] = "Science";
        bookArr[8][2] = "Cosmos";
        bookArr[8][3] = "Carl Sagan";
        bookArr[8][4] = "Ballantine Books";
        bookArr[8][5] = "true";
        bookArr[8][6] = "0000001";
        bookArr[8][7] = "20190621";
        bookArr[8][8] = "20190705";

        bookArr[9][0] = "0000010";
        bookArr[9][1] = "Art";
        bookArr[9][2] = "How to Draw Almost Everthing";
        bookArr[9][3] = "Chika Miyata";
        bookArr[9][4] = "Quarry Books";
        bookArr[9][5] = "false";
        bookArr[9][6] = "";
        bookArr[9][7] = "";
        bookArr[9][8] = "";

        bookArr[10][0] = "0000011";
        bookArr[10][1] = "Society";
        bookArr[10][2] = "Homo Deus";
        bookArr[10][3] = "Yuval Noah";
        bookArr[10][4] = "Vintage";
        bookArr[10][5] = "true";
        bookArr[10][6] = "0000004";
        bookArr[10][7] = "20190617";
        bookArr[10][8] = "20190701";

        bookArr[11][0] = "0000012";
        bookArr[11][1] = "Society";
        bookArr[11][2] = "Guns, Germs, and Steel";
        bookArr[11][3] = "Jared Diamond";
        bookArr[11][4] = "Norton & Company";
        bookArr[11][5] = "true";
        bookArr[11][6] = "0000004";
        bookArr[11][7] = "20190616";
        bookArr[11][8] = "20190630";
        
        bookArr[12][0] = "0000013";
        bookArr[12][1] = "Society";
        bookArr[12][2] = "Nudge";
        bookArr[12][3] = "Richard Thaler";
        bookArr[12][4] = "Penguin Books";
        bookArr[12][5] = "false";
        bookArr[12][6] = "";
        bookArr[12][7] = "";
        bookArr[12][8] = "";
        
        bookArr[13][0] = "0000014";
        bookArr[13][1] = "Art";
        bookArr[13][2] = "The Story of Art";
        bookArr[13][3] = "E.H. Gombrich";
        bookArr[13][4] = "Phaidon Press";
        bookArr[13][5] = "false";
        bookArr[13][6] = "";
        bookArr[13][7] = "";
        bookArr[13][8] = "";
        
        bookArr[14][0] = "0000015";
        bookArr[14][1] = "Art";
        bookArr[14][2] = "The Art of Dishonored";
        bookArr[14][3] = "Bethesda Software";
        bookArr[14][4] = "Dark Horse Comics";
        bookArr[14][5] = "true";
        bookArr[14][6] = "0000003";
        bookArr[14][7] = "20190622";
        bookArr[14][8] = "20190706";
        
        bookArr[15][0] = "0000016";
        bookArr[15][1] = "Science";
        bookArr[15][2] = "Mathematical Analysis";
        bookArr[15][3] = "Walter Rudin";
        bookArr[15][4] = "McGraw Hill";
        bookArr[15][5] = "false";
        bookArr[15][6] = "";
        bookArr[15][7] = "";
        bookArr[15][8] = "";
        
        bookArr[16][0] = "0000017";
        bookArr[16][1] = "Art";
        bookArr[16][2] = "Botanical Style";
        bookArr[16][3] = "Sellina Lake";
        bookArr[16][4] = "Peters & Small";
        bookArr[16][5] = "true";
        bookArr[16][6] = "0000003";
        bookArr[16][7] = "20190620";
        bookArr[16][8] = "20190704";
        
        bookArr[17][0] = "0000018";
        bookArr[17][1] = "Humanities";
        bookArr[17][2] = "Justice";
        bookArr[17][3] = "Michael Sandel";
        bookArr[17][4] = "Farrar Straus";
        bookArr[17][5] = "false";
        bookArr[17][6] = "";
        bookArr[17][7] = "";
        bookArr[17][8] = "";
        
        bookArr[18][0] = "0000019";
        bookArr[18][1] = "Humanities";
        bookArr[18][2] = "The Conquest of Happiness";
        bookArr[18][3] = "Bertrand Russell";
        bookArr[18][4] = "Liveright Publishing";
        bookArr[18][5] = "true";
        bookArr[18][6] = "0000003";
        bookArr[18][7] = "20190621";
        bookArr[18][8] = "20190705";

        bookArr[19][0] = "0000020";
        bookArr[19][1] = "Art";
        bookArr[19][2] = "The Secret Lives of Color";
        bookArr[19][3] = "Kassia St Clair";
        bookArr[19][4] = "Penguin Books";
        bookArr[19][5] = "false";
        bookArr[19][6] = "";
        bookArr[19][7] = "";
        bookArr[19][8] = "";

        bookArr[20][0] = "0000021";
        bookArr[20][1] = "Society";
        bookArr[20][2] = "Outliers";
        bookArr[20][3] = "Malcolm Gladwell";
        bookArr[20][4] = "Back Bay Books";
        bookArr[20][5] = "true";
        bookArr[20][6] = "0000003";
        bookArr[20][7] = "20190617";
        bookArr[20][8] = "20190701";

        bookArr[21][0] = "0000022";
        bookArr[21][1] = "Society";
        bookArr[21][2] = "The Tipping Point";
        bookArr[21][3] = "Malcolm Gladwell";
        bookArr[21][4] = "Back Bay Books";
        bookArr[21][5] = "false";
        bookArr[21][6] = "";
        bookArr[21][7] = "";
        bookArr[21][8] = "";
        
        bookArr[22][0] = "0000023";
        bookArr[22][1] = "Science";
        bookArr[22][2] = "The Sisappearing Spoon";
        bookArr[22][3] = "Sam Kean";
        bookArr[22][4] = "Back Bay Books";
        bookArr[22][5] = "false";
        bookArr[22][6] = "";
        bookArr[22][7] = "";
        bookArr[22][8] = "";
        
        bookArr[23][0] = "0000024";
        bookArr[23][1] = "Art";
        bookArr[23][2] = "Treasures of Botanical Art";
        bookArr[23][3] = "Shirley Sherwood";
        bookArr[23][4] = "Royal Botanic Gardens Kew";
        bookArr[23][5] = "true";
        bookArr[23][6] = "0000002";
        bookArr[23][7] = "20190611";
        bookArr[23][8] = "20190625";
        
        bookArr[24][0] = "0000025";
        bookArr[24][1] = "Humanities";
        bookArr[24][2] = "Coree a Coeur";
        bookArr[24][3] = "Ida Daussy";
        bookArr[24][4] = "Ateller Des Cahiers";
        bookArr[24][5] = "true";
        bookArr[24][6] = "0000004";
        bookArr[24][7] = "20190622";
        bookArr[24][8] = "20190706";
        
        bookArr[25][0] = "0000026";
        bookArr[25][1] = "Humanities";
        bookArr[25][2] = "Choose the Right Word";
        bookArr[25][3] = "Samuel Hayakawa";
        bookArr[25][4] = "Harpercollins";
        bookArr[25][5] = "true";
        bookArr[25][6] = "0000001";
        bookArr[25][7] = "20190621";
        bookArr[25][8] = "20190705";

        boolean user_menu = true;
        
        while (user_menu) {
            // 사용자 선택 메뉴 출력
            System.out.println("다음 회원 선택 또는 회원 가입중에 선택하세요.");
            int last_num=1;
            for (int i=0; i<memberArr.length; i++) {
                if (memberArr[i][1]!=null) {
                    bm.memberselect = memberArr[i][0];
                    System.out.print("  " + last_num + ". " + memberArr[i][1]);
                    last_num++;
                }
            }
            System.out.print("  " + last_num++ + ". 회원가입");
            System.out.print("  " + last_num-- + ". 종료");
            System.out.println();
        
            Scanner sc = new Scanner(System.in);
            int selectmem = sc.nextInt();
            sc.nextLine();
            
            if (selectmem > last_num || selectmem < 0) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else if (selectmem == (last_num--)) { //회원가입
                System.out.println("회원을 가입하겠습니다.");
                System.out.println("회원의 이름을 입력하세요.");
                String name = sc.nextLine();
                System.out.println("회원의 생년월일을 입력하세요. 예) 2019년6월24일 => 20190624 ");
                String birth = sc.nextLine();
                System.out.println("회원의 ID를 입력하세요.");
                String id = sc.nextLine();
                System.out.println("회원의 PW를 입력하세요.");
                String pw = sc.nextLine();
                int num = Integer.parseInt(bm.memberselect)+1;
                String memstr = "000000" + String.valueOf(num);
                memberArr[last_num][0] = memstr;
                memberArr[last_num][1] = name;
                memberArr[last_num][2] = id;
                memberArr[last_num][3] = pw;
                memberArr[last_num][4] = birth;
                
//                // show member
//                for (int i=0; i<memberArr.length; i++) {
//                    if (memberArr[i][1]!=null) {
//                        System.out.println("  " + memberArr[i][0] + "   " + memberArr[i][1] + "   " + memberArr[i][2] + "   " + memberArr[i][3] + "   " + memberArr[i][4]);
//                    }
//                }
            } else {  // member menu member selected
            
                // 아이디 입력
                int login_count = 0;
                boolean id_correct = false, pw_correct = false;
                selectmem -= 1;
                while(login_count<3 && pw_correct == false) {
                    System.out.println("  " + memberArr[selectmem][1] + "님, ID를 입력하세요.");
                    String id = sc.nextLine();
                    if (id.equals(memberArr[selectmem][2])) {
                        // 아이디 일치
                        id_correct = true;
                        // 패스워드 입력
                        System.out.println("비밀번호(password)를 입력하세요.");
                        String pw = sc.nextLine();
                        if (pw.equals(memberArr[selectmem][3])) {
                            // 패스워드 일치
                            pw_correct = true;
                            bm.memberselect = memberArr[selectmem][0];
                            boolean exit = false;
                            while(!exit) {
                                // 메뉴 출력
                                System.out.println("----------------------------------------");
                                System.out.println("      1. 대출     2. 반납     3. 종료       ");
                                System.out.println("----------------------------------------");
                                selectmem = sc.nextInt();
                            
                                if (selectmem == 1) {
                                    // 도서 리스트 출력
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("\t\t" + "제목" + "\t\t\t\t" + "작가" + "\t\t\t\t" + "출판사"+ "\t\t\t" + "대여현황");
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                    
                                    for(int i=0, j=0; i<bookArr.length; i++) {
                                        if (bookArr[i][2] != null) {
                                            j += 1;
                                            System.out.printf("%d. %30s %30s %30s %10s\n", j, bookArr[i][2], bookArr[i][3], bookArr[i][4], (bookArr[i][5] == "true" ? "대여중" : "대출가능"));
                                        }
                                    }
                                    // rental book selection
                                    System.out.println("대여할 책을 선택하세요.");
                                    int booknum = sc.nextInt();
                                    sc.nextLine();
                                
                                    for(int i=0, j=0; i<bookArr.length; i++) {
                                        if (bookArr[i][2] != null) {
                                            j += 1;
                                            if (booknum == j) {
                                                if (bookArr[i][5] == "false") {
                                                    bm.bookselect = bookArr[i][0];
                                                    System.out.println("대여할 도서는 " + bookArr[i][2] + "을 선택했습니다.");
                                                    bookArr[i][5] = "true";
                                                    bookArr[i][6] = bm.memberselect;
                                                    //대여가능 기간 출력
                                                    Calendar cal = new GregorianCalendar();
                                                    Date today = new Date();
                                                    Date returnday = new Date();
                                                    cal.setTime(today);
                                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                                                    //String now = sdf.format(today);
                                                    bookArr[i][7] = sdf.format(today);
                                                    //System.out.println("today : " + sdf.format(today));
                                                    cal.add(Calendar.DATE, 14);
                                                    returnday = cal.getTime();
                                                    bookArr[i][8] = sdf.format(returnday);
                                                    System.out.println("반납할 날짜는 " + sdf.format(returnday) + "입니다.");
                                                } else {
                                                    System.out.println(" " + bookArr[i][2] + "은 대여중입니다.");
                                                }
                                            }
                                        }
                                    }
                                                
                                    // 사용자대여현황 리스트 출력
                                    System.out.println("사용자 대출 도서 리스트");
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("\t\t" + "제목" + "\t\t\t\t" + "작가" + "\t\t\t\t" + "출판사" + "\t\t\t" + "대출일" + "\t" + "반납일");
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                    
                                    for(int k=0, l=0; k<bookArr.length; k++) {
                                        if (bookArr[k][6] == bm.memberselect) {
                                            l += 1;
                                            String rentalMonth = bookArr[k][7].substring(4, 6);
                                            String rentalDay = bookArr[k][7].substring(6);
                                            String returnMonth = bookArr[k][8].substring(4, 6);
                                            String returnDay = bookArr[k][8].substring(6);
                                            System.out.printf("%d. %30s %30s %30s %7s월 %7s일 %7s월 %7s일\n", l, bookArr[k][2], bookArr[k][3], bookArr[k][4], rentalMonth, rentalDay, returnMonth, returnDay);

                                        }
                                    }
                                
                                } else if (selectmem == 2) {
                                    //반납할 도서가 있는지 확인
                                    boolean booksForReturn = false;
                                    for(int i=0; i<bookArr.length; i++) {
                                        if(bookArr[i][6]==bm.memberselect) {
                                            booksForReturn = true;
                                            break;
                                        }
                                    }
                                    
                                    if(booksForReturn) { //반납할 도서가 있다면
                                        // 사용자대여현황 리스트 출력
                                        System.out.println("반납할 책은 아래와 같습니다.");
                                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("\t\t" + "제목" + "\t\t\t\t" + "작가" + "\t\t\t\t" + "출판사" + "\t\t\t" + "대출일" + "\t" + "반납일");
                                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                        
                                        for(int i=0, j=0; i<bookArr.length; i++) {
                                            if(bookArr[i][6]==bm.memberselect) {
                                                j += 1;
                                                String rentalMonth = bookArr[i][7].substring(4, 6);
                                                String rentalDay = bookArr[i][7].substring(6);
                                                String returnMonth = bookArr[i][8].substring(4, 6);
                                                String returnDay = bookArr[i][8].substring(6);
                                                System.out.printf("%d. %30s %30s %30s %7s월 %7s일 %7s월 %7s일\n", j, bookArr[i][2], bookArr[i][3], bookArr[i][4], rentalMonth, rentalDay, returnMonth, returnDay);
                                            }
                                        }
                                        // return book selection
                                        System.out.println("반납할 책을 선택하세요.");
                                        int booknum = sc.nextInt();
                                        sc.nextLine();
                                        for(int i=0, j=0; i<bookArr.length; i++) {
                                            if (bookArr[i][6]==bm.memberselect) {
                                                j += 1;
                                                if (booknum == j) {
                                                    // 반납할 도서 선택
                                                    bm.bookselect = bookArr[i][2];
                                                    System.out.println(" 반납할 책으로 " + bm.bookselect + "을 선택했습니다.");
                                                    bookArr[i][5] = "false";
                                                    bookArr[i][6] = null;
                                                    bookArr[i][7] = null;
                                                    bookArr[i][8] = null;
                                                }
                                            }
                                        }
                                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("\t\t" + "제목" + "\t\t\t\t" + "작가" + "\t\t\t\t" + "출판사" + "\t\t\t" + "대출일" + "\t" + "반납일");
                                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                                        for(int i=0, j=0; i<bookArr.length; i++) {
                                            if(bookArr[i][6]==bm.memberselect) {
                                                j += 1;
                                                String rentalMonth = bookArr[i][7].substring(4, 6);
                                                String rentalDay = bookArr[i][7].substring(6);
                                                String returnMonth = bookArr[i][8].substring(4, 6);
                                                String returnDay = bookArr[i][8].substring(6);
                                                System.out.printf("%d. %30s %30s %30s %7s월 %7s일 %7s월 %7s일\n", j, bookArr[i][2], bookArr[i][3], bookArr[i][4], rentalMonth, rentalDay, returnMonth, returnDay);
                                            }
                                        }
                                    }else { //반납할 도서가 없다면
                                        System.out.println("반납할 도서가 없습니다.");
                                    }
                                } else {
                                    // End the system
                                    exit = true;
                                    break;
                                }
                            }
                        } else { //pw가 일치하지 않는 경우
                            pw_correct = false;
                            // 로그인 실패
                            login_count += 1;
                            System.out.println("로그인을 실패했습니다.");
                            //3회 이상 틀린 경우
                            if (login_count >=3) {
                                System.out.println("사용자 메뉴로 갑니다.");
                                break;
                            }
                            id_correct = false;
                        }
                    } else { //id가 일치하지 않는 경우
                        id_correct = false;
                        // 로그인 실패
                        login_count += 1;
                        System.out.println("로그인을 실패했습니다.");
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

}