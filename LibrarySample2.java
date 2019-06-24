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
    

    // member ������
    public LibrarySample2(String memberName, String id, String pw){
        this.memberName = memberName;
        this.id = id;
        this.pw = pw;
    }
    
    // book ������
    public LibrarySample2(String booktitle) {
        this.booktitle = booktitle;
    }
    
    // reservation ������
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
        
        // ����� �ʱ�ȭ
        LibrarySample2[] member = new LibrarySample2[4];
        member[0] = new LibrarySample2("�迵��", "a", "1111");
        member[1] = new LibrarySample2("������", "b", "2222");
        member[2] = new LibrarySample2("������", "c", "3333");
        member[3] = new LibrarySample2("������", "d", "4444");
        
        // å �ʱ�ȭ
        LibrarySample2[] bookList = new LibrarySample2[10];
        bookList[0] = new LibrarySample2("�ظ�����");
        bookList[1] = new LibrarySample2("�ڹ�������");
        bookList[2] = new LibrarySample2("����");
        bookList[3] = new LibrarySample2("����� �µ�");
        bookList[4] = new LibrarySample2("������ ����");
        bookList[5] = new LibrarySample2("���̾� ��ȭ���� ����");
        bookList[6] = new LibrarySample2("�ϸ��͸� ������ �� �� �ߴ�");
        bookList[7] = new LibrarySample2("�װ������ �����̴� �԰�;�");
        bookList[8] = new LibrarySample2("������ �������� ����� �ִ�");
        bookList[9] = new LibrarySample2("���� ���� ���� �ߴ�");
        
        LibrarySample2[] reservation = new LibrarySample2[10]; // arrayList�� �ٲٱ�!!
        reservation[0] = new LibrarySample2(1, "������", "�ظ�����", 190527, false);
        reservation[1] = new LibrarySample2(2, "������", "����", 190607, true);
        reservation[2] = new LibrarySample2(3, "������", "�ڹ�������", 190610, false);
        reservation[3] = new LibrarySample2(4, "������", "���̾� ��ȭ���� ����", 190617, false);
        reservation[4] = new LibrarySample2(5, "������", "����� �µ�", 190620, false);
        reservation[5] = new LibrarySample2(6, "������", "������ ����", 190626, true);
        reservation[6] = new LibrarySample2(7, "", "", 0, false);
        reservation[7] = new LibrarySample2(8, "", "", 0, false);
        reservation[8] = new LibrarySample2(9, "", "", 0, false);
        reservation[9] = new LibrarySample2(10, "", "", 0, false);
        
        Scanner scan = new Scanner(System.in);

        while (repeat < 4) {
            // ����� ����
            if(repeat == 0 || repeat == 3) {
                repeat = 0;
                System.out.println("����ڸ� �����ϼ���.");
                for(i = 0; i < member.length; i++) {
                    System.out.println((i+1) + ". " + member[i].memberName);
                }
                memberChoice = scan.nextInt();
                scan.nextLine();
            }
            // id, pw�Է¹ޱ�
            System.out.print("id�� �Է��ϼ��� : ");
            String inputId = scan.nextLine();
            System.out.print("pw�� �Է��ϼ��� : ");
            String inputPw = scan.nextLine();

            // �α��μ���
            if (inputId.equals(member[memberChoice - 1].id) && inputPw.equals(member[memberChoice - 1].pw)) {
                System.out.println(member[memberChoice - 1].memberName + "�� �ݰ����ϴ�.");

                // �뿩, �ݳ�, ���� ����
                System.out.println("���� �� �ϳ��� �����ϼ���.");
                System.out.println("1.�뿩 2.�ݳ� 3.����");
                choice = scan.nextInt();
                
                if (choice == 1) { // �뿩
                    while(true) {
                        // ��������Ʈ ���
                        System.out.println("< ��������Ʈ >");
                        for(j = 0; j < bookList.length; j++) {
                            System.out.println((j+1) + ". " + bookList[j].toString());
                        }
                        // �뿩�� ���� ����
                        System.out.println("�뿩�� ���� ��ȣ�� �Է��ϼ���.");
                        bookChoice = scan.nextInt();
                        scan.nextLine();
                        // �뿩���� �������� Ȯ��
                        for(int k = 0; k < reservation.length; k++) {
                            if(reservation[k].booktitle.equals(bookList[bookChoice-1].booktitle)) {
                                if(reservation[k].isReturned == false) { // �뿩���� �����̸�
                                    System.out.println("�̹� �뿩���� å�Դϴ�.");
                                    isreturned = false;
                                    break;
                                }
                            }
                            isreturned = true;
                        }
                        // �뿩���� ������ �ƴϸ�
                        if(isreturned == true) {
                            // reservation�� �߰�
                            reservation[reservationNum] = new LibrarySample2((reservationNum + 1), member[memberChoice - 1].memberName, bookList[bookChoice - 1].booktitle, 190629, false); // ���� ��¥�� �Էµǵ��� �����ؾ��� !!
                            reservationNum++;
                            System.out.println("�ݳ����� 2019�� 7�� 20�� �Դϴ�."); // ���� ��¥�� ���� ��¥�� ��µǵ��� �����ؾ���!!
                            break;
                        }
                    }
                    break;
                } else if (choice == 2) { // �ݳ�
                    // ����ڴ뿩��Ȳ ����Ʈ ���(�뿩�Ⱓ)
                    System.out.println("< ����ڴ뿩��Ȳ >");
                    for(int l = 0; l < reservation.length; l++) {
                        if(reservation[l].memberName.equals(member[memberChoice - 1].memberName)) {
                            if(reservation[l].isReturned == false) {
                            System.out.println("�뿩��ȣ : " + reservation[l].reservationNum + ", å�̸� : " + reservation[l].booktitle + ", �ݳ����� : " + reservation[l].rentStartDate);
                            }
                        }
                    }
                    // �ݳ��� ���� ����
                    System.out.print("�ݳ��� ������ �뿩��ȣ�� �Է��ϼ��� : ");
                    returnCoice = scan.nextInt();
                    scan.nextLine();
                    // reservation�� isReturned����
                    reservation[returnCoice - 1].isReturned = true;
                    System.out.println("< ����ڴ뿩��Ȳ >");
                    for(int l = 0; l < reservation.length; l++) {
                        if((reservation[l].memberName.equals(member[memberChoice - 1].memberName)) && (reservation[l].isReturned == false)) {
                            System.out.println("�뿩��ȣ : " + reservation[l].reservationNum + ", å�̸� : " + reservation[l].booktitle + ", �ݳ����� : " + reservation[l].rentStartDate);
                        }
                    }
                    break;
                } else if (choice == 3) { // ����
                    // ���α׷�����
                    break;
                }
            } else {// �α��ν���
                // ����ڼ������� ���ư���
                System.out.println("�α��ο� �����߽��ϴ�.(" + (repeat + 1) + "/3)");
                repeat++;
            }
        }

    }
}