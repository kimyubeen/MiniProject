package praticeproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class teamproject02 {
    public static void main(String[] args) {
        boolean checker = true;
        boolean checker2;
        boolean endminer = true;
        boolean allrepeater = true;
        int checkcnt = 0;
        int idcnt = 0;
        int memorial = 0;
        String cthid = "cth1";
        String cthpw = "cth2";
        String lyjid = "lyj1";
        String lyjpw = "lyj2";
        String kybid = "kyb1";
        String kybpw = "kyb2";
        String kyjid = "kyj1";
        String kyjpw = "kyj2";
        String rentaldue = null;
        Date rentalduedate = new Date();
        SimpleDateFormat timeformat =new SimpleDateFormat("MM-dd");
        Scanner scan = new Scanner(System.in);
        String humanities[] = { "인문책1", "인문책2", "인문책3", "인문책4", "인문책5" };
        String social[] = { "사회책1", "사회책2", "사회책3", "사회책4", "사회책5" };
        String science[] = { "과학책1", "과학책2", "과학책3", "과학책4", "과학책5" };
        String art[] = { "예술책1", "예술책2", "예술책3", "예술책4", "예술책4", "예술책5" };
        ArrayList<String> cthbooklist = new ArrayList<>();
        ArrayList<String> lyjbooklist = new ArrayList<>();
        ArrayList<String> kybbooklist = new ArrayList<>();
        ArrayList<String> kyjbooklist = new ArrayList<>();
        while (allrepeater) { checker = true;
            while (checker) {
                System.out.println("사용자를 선택하세요 1:최태훈 2:이유정3:김유빈4:김영준");
                int w = scan.nextInt();
                memorial = w;
                if (w == 1) {
                    checkcnt = 0;
                    System.out.println("최태훈님 id 를 입력하세요");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("최태훈님 pw 를 입력하세요");
                        String pw1 = scan.next();
                        if (id1.equals(cthid) && pw1.equals(cthpw)) {
                            System.out.println("로그인 성공");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("로그인 실패" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 2) {
                    checkcnt = 0;
                    System.out.println("이유정님 id 를 입력하세요");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("이유정님 pw 를 입력하세요");
                        String pw1 = scan.next();
                        if (id1.equals(lyjid) && pw1.equals(lyjpw)) {
                            System.out.println("로그인 성공");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("로그인 실패" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 3) {
                    checkcnt = 0;
                    System.out.println("김유빈님 id 를 입력하세요");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("김유빈님 pw 를 입력하세요");
                        String pw1 = scan.next();
                        if (id1.equals(kybid) && pw1.equals(kybpw)) {
                            System.out.println("로그인 성공");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("로그인 실패" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 4) {
                    checkcnt = 0;
                    System.out.println("김영준님 id 를 입력하세요");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("김영준님 pw 를 입력하세요");
                        String pw1 = scan.next();
                        if (id1.equals(kyjid) && pw1.equals(kyjpw)) {
                            System.out.println("로그인 성공");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("로그인 실패" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                }
            }
            endminer =true;
            while (endminer) {
                System.out.println("원하는메뉴를 선택해주세요 1: 대여  2: 반납 3: 대여현황  4: 사용자선택메뉴  5: 종료 ");
                int menu = scan.nextInt();
                if (menu == 1) {
                    System.out.println("메뉴'대여'를 선택하셨습니다.");
                    System.out.println("책의 종류를 선택해주세요 1: 인문 2: 사회 3: 과학 4: 예술 ");
                    int kind = scan.nextInt();
                    if (kind == 1) {
                        System.out.println("인문을 선택하셨습니다 책의목록을 공개합니다");
                        for (String k : humanities) {
                            System.out.println(k);
                        }
                        System.out.println("대여하고자하는 책의번호를 입력하세요");
                        int booknum = scan.nextInt();
                        if (humanities[booknum - 1].length() == 4) {
                            System.out.println("대여가능한책입니다.");
                            if (memorial == 1) {
                                String bookna = humanities[booknum - 1];
                                cthbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                                
                            } else if (memorial == 2) {
                                String bookna = humanities[booknum - 1];
                                lyjbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = humanities[booknum - 1];
                                kybbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = humanities[booknum - 1];
                                kyjbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            }
                        } else {
                            System.out.println("다른회원이 이미 대여중인 도서입니다.");
                        }
                    } else if (kind == 2) {
                        System.out.println("사회을 선택하셨습니다 책의목록을 공개합니다");
                        for (String k : social) {
                            System.out.println(k);
                        }
                        System.out.println("대여하고자하는 책의번호를 입력하세요");
                        int booknum = scan.nextInt();

                        if (social[booknum - 1].length() == 4) {
                            System.out.println("대여가능한책입니다.");
                            if (memorial == 1) {
                                String bookna = social[booknum - 1];
                                cthbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = social[booknum - 1];
                                lyjbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = social[booknum - 1];
                                kybbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = social[booknum - 1];
                                kyjbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            }
                        } else {
                            System.out.println("다른회원이 이미 대여중인 도서입니다.");
                        }

                    } else if (kind == 3) {
                        System.out.println("과학을 선택하셨습니다 책의목록을 공개합니다");
                        for (String k : science) {
                            System.out.println(k);
                        }
                        System.out.println("대여하고자하는 책의번호를 입력하세요");
                        int booknum = scan.nextInt();
                        if (science[booknum - 1].length() == 4) {
                            System.out.println("대여가능한책입니다.");
                            if (memorial == 1) {
                                String bookna = science[booknum - 1];
                                cthbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = science[booknum - 1];
                                lyjbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = science[booknum - 1];
                                kybbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = science[booknum - 1];
                                kyjbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            }
                        } else {
                            System.out.println("다른회원이 이미 대여중인 도서입니다.");
                        }
                    }

                    else if (kind == 4) {
                        System.out.println("문학을 선택하셨습니다 책의목록을 공개합니다");
                        for (String k : art) {
                            System.out.println(k);
                        }
                        System.out.println("대여하고자하는 책의번호를 입력하세요");
                        int booknum = scan.nextInt();

                        if (art[booknum - 1].length() == 4) {
                            System.out.println("대여가능한책입니다.");
                            if (memorial == 1) {
                                String bookna = art[booknum - 1];
                                cthbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = art[booknum - 1];
                                lyjbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = art[booknum - 1];
                                kybbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = art[booknum - 1];
                                kyjbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "대여중";
                                System.out.println("대여를 성공적으로 완료하셨습니다");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("대여 만료 기한:"+rentaldue);
                            }
                        } else {
                            System.out.println("다른회원이 이미 대여중인 도서입니다.");
                        }
                    }

                } else if (menu == 2) {
                    if (memorial == 1) {
                        System.out.println("최태훈님의 대여현황");
                        for (int i = 0; i < cthbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + cthbooklist.get(i));
                        }
                        System.out.println("반납할 책의 번호를 입력해주세요 ");
                        int returnbooknum = scan.nextInt();
                        if(cthbooklist.get(returnbooknum-1).charAt(0)=='인') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='사') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='과') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='예') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }
                        

                    } else if (memorial == 2) {
                        System.out.println("이유정님의 대여현황");
                        for (int i = 0; i < lyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + lyjbooklist.get(i));
                        }
                        System.out.println("반납할 책의 번호를 입력해주세요 ");
                        int returnbooknum = scan.nextInt();
                        if(lyjbooklist.get(returnbooknum-1).charAt(0)=='인') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='사') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='과') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='예') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }
                        
                    } else if (memorial == 3) {
                        System.out.println("김유빈님의 대여현황");
                        for (int i = 0; i < kybbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + kybbooklist.get(i));
                        }
                        System.out.println("반납할 책의 번호를 입력해주세요 ");
                        int returnbooknum = scan.nextInt();
                        if(kybbooklist.get(returnbooknum-1).charAt(0)=='인') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='사') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='과') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='예') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }
                    } else if (memorial == 4) {
                        System.out.println("김영준님의 대여현황");
                        for (int i = 0; i < kyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + kyjbooklist.get(i));
                        }
                        System.out.println("반납할 책의 번호를 입력해주세요 ");
                        int returnbooknum = scan.nextInt();
                        if(kyjbooklist.get(returnbooknum-1).charAt(0)=='인') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='사') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='과') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='예') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("반납을 성공적으로 완료했습니다");
                        }
                    }

                } else if (menu == 3) {
                    if (memorial == 1) {
                        System.out.println("최태훈님의 대여현황");
                        for (int i = 0; i < cthbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + cthbooklist.get(i));
                        }
                    } else if (memorial == 2) {
                        System.out.println("이유정님의 대여현황");
                        for (int i = 0; i < lyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + lyjbooklist.get(i));
                        }
                    } else if (memorial == 3) {
                        System.out.println("김유빈님의 대여현황");
                        for (int i = 0; i < kybbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + kybbooklist.get(i));
                        }
                    } else if (memorial == 4) {
                        System.out.println("김영준님의 대여현황");
                        for (int i = 0; i < kyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "번" + kyjbooklist.get(i));
                        }
                    }

                } else if (menu == 4) {
                    endminer = false;
                } else if (menu == 5) {
                    endminer = false;
                    allrepeater =false;

                }

            }
        }
    }
}
