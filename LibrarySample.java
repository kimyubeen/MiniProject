import java.util.Scanner;
//회원가입

public class LibrarySample{

    private String name;
    private String id;
    private String pw;

    public LibrarySample(String name, String id, String pw){
        this.name = name;
        this.id = id;
        this.pw = pw;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return this.id;
    }

    public static void main(String[] args) {
        int repeat = 0;
        int memberChoice = 0;
        int choice1 = 0;
        int i = 0;
        int SIZE = 3;
        // 사용자 초기화
        LibrarySample[] member = new LibrarySample[SIZE];
        

        while (repeat < 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.회원가입 2.로그인");
            choice1 = scan.nextInt();
            scan.nextLine();
            if(choice1 == 1 && i < SIZE) {
                System.out.println("이름을 입력하세요.");
                String memberName = scan.nextLine();
                System.out.println("아이디를 입력하세요.");
                String memberId = scan.nextLine();
                System.out.println("비밀번호를 입력하세요.");
                String memberPw = scan.nextLine();
                member[i] = new LibrarySample(memberName, memberId, memberPw);
                i++;
                System.out.println("회원가입이 완료되었습니다");
                continue;
            }else if(choice1 == 2) {
                System.out.print("id를 입력하세요 : ");
                String inputId = scan.nextLine();
                System.out.print("pw를 입력하세요 : ");
                String inputPw = scan.nextLine();
                for(int j = 0 ; j < member.length; j++) {
                    
                }
                if(inputId.equals(member[i-1].id) && inputPw.equals(member[i-1].pw)) {
                    System.out.println("로그인 되었습니다.");
                    System.out.println("다음 중 하나를 선택하세요.");
                    System.out.println("1.대여 2.반납 3.종료");
                    int choice2 = scan.nextInt();
                    // 대여
                    if (choice2 == 1) {
                        // 도서리스트 출력
                        System.out.println("도서 리스트");
                        // (도서분야선택)
                        // 대여할 도서 선택
                        
                        // 사용자대여현황 리스트에 추가
                    } else if (choice2 == 2) { // 반납
                        // 사용자대여현황 리스트 출력(대여기간)
                        System.out.println("사용자대여현황");
                        // 반납할 도서 선택
                        // 사용자대여현황 리스트에서 삭제
                        // 도서리스트의 '대여가능' 필드부분 변경
                    } else if (choice2 == 3) { // 종료
                        // 프로그램종료
                        break;
                    }
                } else {
                    // 로그인실패
                    // 사용자선택으로 돌아가기
                    System.out.println("로그인에 실패했습니다.(" + (repeat + 1) + "/3)");
                    repeat++;
                }
            }else if(i == SIZE){
                System.out.println("회원이 꽉 찼습니다.");
                break;
            }else {
                System.out.println("다시 입력하세요.");
            }
        }

    }
}
