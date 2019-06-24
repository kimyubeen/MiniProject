import java.awt.print.Book;
import java.util.Scanner;

public class LibrarySample2 {

    private String memberName;
    private String id;
    private String pw;
    private String booktitle;
    private int reservationNum;
    private int rentStartDate;
    private boolean isReturned;
    

    // member 생성자
    public LibrarySample2(String memberName, String id, String pw){
        this.memberName = memberName;
        this.id = id;
        this.pw = pw;
    }
    
    // book 생성자
    public LibrarySample2(String booktitle) {
        this.booktitle = booktitle;
    }
    
    // reservation 생성자
    public LibrarySample2(int reservationNum, String memberName, String booktitle, int rentStartDate, boolean isReturned) {
        this.reservationNum = reservationNum;
        this.memberName = memberName;
        this.booktitle = booktitle;
        this.rentStartDate = rentStartDate;
        this.isReturned = isReturned;
    }
    
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getBooktitle() {
        return booktitle;
    }
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
    public int getReservationNum() {
        return reservationNum;
    }
    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }
    public int getRentStartDate() {
        return rentStartDate;
    }
    public void setRentStartDate(int rentStartDate) {
        this.rentStartDate = rentStartDate;
    }
    public boolean getIsReturned() {
        return isReturned;
    }
    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
    
    public String toString() {
        return this.booktitle;
    }
    
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int repeat = 0;
        int memberChoice = 0;
        int bookChoice = 0;
        int choice = 0;
        int reservationNum = 0;
        int returnCoice = 0;
        boolean isreturned = true;
        
        // 사용자 초기화
        LibrarySample2[] member = new LibrarySample2[4];
        member[0] = new LibrarySample2("김영준", "a", "1111");
        member[1] = new LibrarySample2("김유빈", "b", "2222");
        member[2] = new LibrarySample2("이유정", "c", "3333");
        member[3] = new LibrarySample2("최태훈", "d", "4444");
        
        // 책 초기화
        LibrarySample2[] bookList = new LibrarySample2[10];
        bookList[0] = new LibrarySample2("해리포터");
        bookList[1] = new LibrarySample2("자바의정석");
        bookList[2] = new LibrarySample2("개미");
        bookList[3] = new LibrarySample2("언어의 온도");
        bookList[4] = new LibrarySample2("여행의 이유");
        bookList[5] = new LibrarySample2("나미야 잡화점의 기적");
        bookList[6] = new LibrarySample2("하마터면 열심히 살 뻔 했다");
        bookList[7] = new LibrarySample2("죽고싶지만 떡볶이는 먹고싶어");
        bookList[8] = new LibrarySample2("끌리는 말투에는 비밀이 있다");
        bookList[9] = new LibrarySample2("나는 나로 살기로 했다");
        
        LibrarySample2[] reservation = new LibrarySample2[10]; // arrayList로 바꾸기!!
        reservation[0] = new LibrarySample2(1, "김유빈", "해리포터", 190527, false);
        reservation[1] = new LibrarySample2(2, "김유빈", "개미", 190607, true);
        reservation[2] = new LibrarySample2(3, "김유빈", "자바의정석", 190610, false);
        reservation[3] = new LibrarySample2(4, "김유빈", "나미야 잡화점의 기적", 190617, false);
        reservation[4] = new LibrarySample2(5, "김유빈", "언어의 온도", 190620, false);
        reservation[5] = new LibrarySample2(6, "김유빈", "여행의 이유", 190626, true);
        reservation[6] = new LibrarySample2(7, "", "", 0, false);
        reservation[7] = new LibrarySample2(8, "", "", 0, false);
        reservation[8] = new LibrarySample2(9, "", "", 0, false);
        reservation[9] = new LibrarySample2(10, "", "", 0, false);
        
        Scanner scan = new Scanner(System.in);

        while (repeat < 4) {
            // 사용자 선택
            if(repeat == 0 || repeat == 3) {
                repeat = 0;
                System.out.println("사용자를 선택하세요.");
                for(i = 0; i < member.length; i++) {
                    System.out.println((i+1) + ". " + member[i].memberName);
                }
                memberChoice = scan.nextInt();
                scan.nextLine();
            }
            // id, pw입력받기
            System.out.print("id를 입력하세요 : ");
            String inputId = scan.nextLine();
            System.out.print("pw를 입력하세요 : ");
            String inputPw = scan.nextLine();

            // 로그인성공
            if (inputId.equals(member[memberChoice - 1].id) && inputPw.equals(member[memberChoice - 1].pw)) {
                System.out.println(member[memberChoice - 1].memberName + "님 반갑습니다.");

                // 대여, 반납, 종료 선택
                System.out.println("다음 중 하나를 선택하세요.");
                System.out.println("1.대여 2.반납 3.종료");
                choice = scan.nextInt();
                
                if (choice == 1) { // 대여
                    while(true) {
                        // 도서리스트 출력
                        System.out.println("< 도서리스트 >");
                        for(j = 0; j < bookList.length; j++) {
                            System.out.println((j+1) + ". " + bookList[j].toString());
                        }
                        // 대여할 도서 선택
                        System.out.println("대여할 도서 번호를 입력하세요.");
                        bookChoice = scan.nextInt();
                        scan.nextLine();
                        // 대여중인 도서인지 확인
                        for(int k = 0; k < reservation.length; k++) {
                            if(reservation[k].booktitle.equals(bookList[bookChoice-1].booktitle)) {
                                if(reservation[k].isReturned == false) { // 대여중인 도서이면
                                    System.out.println("이미 대여중인 책입니다.");
                                    isreturned = false;
                                    break;
                                }
                            }
                            isreturned = true;
                        }
                        // 대여중인 도서가 아니면
                        if(isreturned == true) {
                            // reservation에 추가
                            reservation[reservationNum] = new LibrarySample2((reservationNum + 1), member[memberChoice - 1].memberName, bookList[bookChoice - 1].booktitle, 190629, false); // 현재 날짜가 입력되도록 변경해야함 !!
                            reservationNum++;
                            System.out.println("반납일은 2019년 7월 20일 입니다."); // 현재 날짜에 더한 날짜가 출력되도록 변경해야함!!
                            break;
                        }
                    }
                    break;
                } else if (choice == 2) { // 반납
                    // 사용자대여현황 리스트 출력(대여기간)
                    System.out.println("< 사용자대여현황 >");
                    for(int l = 0; l < reservation.length; l++) {
                        if(reservation[l].memberName.equals(member[memberChoice - 1].memberName)) {
                            if(reservation[l].isReturned == false) {
                            System.out.println("대여번호 : " + reservation[l].reservationNum + ", 책이름 : " + reservation[l].booktitle + ", 반납기한 : " + reservation[l].rentStartDate);
                            }
                        }
                    }
                    // 반납할 도서 선택
                    System.out.print("반납할 도서의 대여번호를 입력하세요 : ");
                    returnCoice = scan.nextInt();
                    scan.nextLine();
                    // reservation의 isReturned변경
                    reservation[returnCoice - 1].isReturned = true;
                    System.out.println("< 사용자대여현황 >");
                    for(int l = 0; l < reservation.length; l++) {
                        if((reservation[l].memberName.equals(member[memberChoice - 1].memberName)) && (reservation[l].isReturned == false)) {
                            System.out.println("대여번호 : " + reservation[l].reservationNum + ", 책이름 : " + reservation[l].booktitle + ", 반납기한 : " + reservation[l].rentStartDate);
                        }
                    }
                    break;
                } else if (choice == 3) { // 종료
                    // 프로그램종료
                    break;
                }
            } else {// 로그인실패
                // 사용자선택으로 돌아가기
                System.out.println("로그인에 실패했습니다.(" + (repeat + 1) + "/3)");
                repeat++;
            }
        }

    }
}