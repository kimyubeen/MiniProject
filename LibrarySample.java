import java.util.Scanner;
//ȸ������

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
        // ����� �ʱ�ȭ
        LibrarySample[] member = new LibrarySample[SIZE];
        

        while (repeat < 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.ȸ������ 2.�α���");
            choice1 = scan.nextInt();
            scan.nextLine();
            if(choice1 == 1 && i < SIZE) {
                System.out.println("�̸��� �Է��ϼ���.");
                String memberName = scan.nextLine();
                System.out.println("���̵� �Է��ϼ���.");
                String memberId = scan.nextLine();
                System.out.println("��й�ȣ�� �Է��ϼ���.");
                String memberPw = scan.nextLine();
                member[i] = new LibrarySample(memberName, memberId, memberPw);
                i++;
                System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
                continue;
            }else if(choice1 == 2) {
                System.out.print("id�� �Է��ϼ��� : ");
                String inputId = scan.nextLine();
                System.out.print("pw�� �Է��ϼ��� : ");
                String inputPw = scan.nextLine();
                for(int j = 0 ; j < member.length; j++) {
                    
                }
                if(inputId.equals(member[i-1].id) && inputPw.equals(member[i-1].pw)) {
                    System.out.println("�α��� �Ǿ����ϴ�.");
                    System.out.println("���� �� �ϳ��� �����ϼ���.");
                    System.out.println("1.�뿩 2.�ݳ� 3.����");
                    int choice2 = scan.nextInt();
                    // �뿩
                    if (choice2 == 1) {
                        // ��������Ʈ ���
                        System.out.println("���� ����Ʈ");
                        // (�����о߼���)
                        // �뿩�� ���� ����
                        
                        // ����ڴ뿩��Ȳ ����Ʈ�� �߰�
                    } else if (choice2 == 2) { // �ݳ�
                        // ����ڴ뿩��Ȳ ����Ʈ ���(�뿩�Ⱓ)
                        System.out.println("����ڴ뿩��Ȳ");
                        // �ݳ��� ���� ����
                        // ����ڴ뿩��Ȳ ����Ʈ���� ����
                        // ��������Ʈ�� '�뿩����' �ʵ�κ� ����
                    } else if (choice2 == 3) { // ����
                        // ���α׷�����
                        break;
                    }
                } else {
                    // �α��ν���
                    // ����ڼ������� ���ư���
                    System.out.println("�α��ο� �����߽��ϴ�.(" + (repeat + 1) + "/3)");
                    repeat++;
                }
            }else if(i == SIZE){
                System.out.println("ȸ���� �� á���ϴ�.");
                break;
            }else {
                System.out.println("�ٽ� �Է��ϼ���.");
            }
        }

    }
}
