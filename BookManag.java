
import java.util.*;
import java.text.*;

public class BookManag {

	private static String memberselect;   // member number
	private static String bookselect;     // book number
	
	public static void main(String[] args) {
		
		BookManag bm = new BookManag();
		// ȸ�� ����Ÿ
		String memberArr[][] = new String[10][5];
		memberArr[0][0] = "0000001";        // number
		memberArr[0][1] = "Kim Young Jun";  // name
		memberArr[0][2] = "augustine";      // ID
		memberArr[0][3] = "young";          // PW
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
		String bookArr[][] = new String[20][7];
		bookArr[0][0] = "0000001";                 // Number
		bookArr[0][1] = "Java Coding Guideline";   // Title
		bookArr[0][2] = "Fred Long";               // Author
		bookArr[0][3] = "Addison Wesley";          // Publisher
		bookArr[0][4] = "0000001";                 // Member
		bookArr[0][5] = "20190601";                // Start Date
		bookArr[0][6] = "20190615";                // End Date

		bookArr[1][0] = "0000002";                   // Number
		bookArr[1][1] = "Java Network Programming";   // Title
		bookArr[1][2] = "Elliotte Rusty";               // Author
		bookArr[1][3] = "OReilly Media";           // Publisher
		bookArr[1][4] = "0000002";                 // Member
		bookArr[1][5] = "20190602";                // Start Date
		bookArr[1][6] = "20190616";                // End Date

		bookArr[2][0] = "0000003";                 // Number
		bookArr[2][1] = "Java Performance";   // Title
		bookArr[2][2] = "Scott Oaks";               // Author
		bookArr[2][3] = "OReilly Media";          // Publisher
		//bookArr[2][4] = "";           // Member
		//bookArr[2][5] = "";                // Start Date
		//bookArr[2][6] = "";                // End Date

		bookArr[3][0] = "0000004";                 // Number
		bookArr[3][1] = "Harry Potter and the Sorcerer";   // Title
		bookArr[3][2] = "Mary GrandPre";               // Author
		bookArr[3][3] = "Scholastic";          // Publisher
		bookArr[3][4] = "0000004";           // Member
		bookArr[3][5] = "20190610";                // Start Date
		bookArr[3][6] = "20190624";                // End Date

		bookArr[4][0] = "0000005";                 // Number
		bookArr[4][1] = "The Silent Patient";   // Title
		bookArr[4][2] = "Alex Michaelides";               // Author
		bookArr[4][3] = "Celadon";          // Publisher
		bookArr[4][4] = "0000003";           // Member
		bookArr[4][5] = "20190614";                // Start Date
		bookArr[4][6] = "20190628";                // End Date

		bookArr[5][0] = "0000006";
		bookArr[5][1] = "Tuesdays with Morrie";
		bookArr[5][2] = "Mitch Albom";
		bookArr[5][3] = "Anchor Books";
		//bookArr[5][4] = "";
		//bookArr[5][5] = "";
		//bookArr[5][6] = "";

		bookArr[6][0] = "0000007";
		bookArr[6][1] = "Basic Grammar In Use";
		bookArr[6][2] = "Raymond Murphy";
		bookArr[6][3] = "Cambridge";
		bookArr[6][4] = "0000001";
		bookArr[6][5] = "20190620";
		bookArr[6][6] = "20190704";

		bookArr[7][0] = "0000008";
		bookArr[7][1] = "Aladdin";
		bookArr[7][2] = "Elkizabeth Rubnick";
		bookArr[7][3] = "Disney Press";
		bookArr[7][4] = "0000002";
		bookArr[7][5] = "20190622";
		bookArr[7][6] = "20190706";
		
		// ����� ����
		System.out.println("���� ȸ���߿� �����ϼ���.");
		int last_num=0;
		for (int i=0; i<memberArr.length; i++) {
			if (memberArr[i][1]!=null) {
				System.out.print("  " + i + ". " + memberArr[i][1]);
				last_num = i + 1;
			}
		}
		System.out.print("  " + last_num + ". Exit");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int selectmem = sc.nextInt();
		
		if (selectmem == last_num) {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
		
		// ���̵� �Է�
		int login_count = 0;
		boolean id_correct = false, pw_correct = false;
		while(login_count<3 && pw_correct == false) {
			System.out.println("  " + memberArr[selectmem][1] + "��, ID�� �Է��ϼ���.");
			String id = sc.next();
			if (id.equals(memberArr[selectmem][2])) {
				id_correct = true;
				// �н����� �Է�
				System.out.println("��й�ȣ(password)�� �Է��ϼ���.");
				String pw = sc.next();
				if (pw.equals(memberArr[selectmem][3])) {
					// �н����� ��ġ
					pw_correct = true;
					bm.memberselect = memberArr[selectmem][0];
				} else {
					pw_correct = false;
					// �α��� ���� (3ȸ �̻� Ʋ�� ���)
					login_count += 1;
					System.out.println("�α����� �����߽��ϴ�.");
					if (login_count >=3) {
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
					}
					id_correct = false;
				}
			} else {
				id_correct = false;
				// �α��� ���� (3ȸ �̻� Ʋ�� ���)
				login_count += 1;
				System.out.println("�α����� �����߽��ϴ�.");
				if (login_count >=3) {
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
				}
			}
		}
		// �α��� ����

		boolean exit = false;
		while(!exit) {
			// �޴� ���
			System.out.println("----------------------------------------");
			System.out.println("      1. ����,     2. �ݳ�,     3. ����       ");
			System.out.println("----------------------------------------");
			selectmem = sc.nextInt();
		
			if (selectmem == 1) {
				// ���� ����Ʈ ���
				System.out.println("������ ������ ���� ����Ʈ");
				System.out.println("\t" + "����" + "\t\t\t" + "�۰�" + "\t\t\t" + "���ǻ�");
				for(int i=0, j=0; i<bookArr.length; i++) {
					if ((bookArr[i][1] != null) && (bookArr[i][4] == null)) {
						j += 1;
						System.out.println(" " + j + ". " + bookArr[i][1] + "\t" + bookArr[i][2] + "\t" + bookArr[i][3]);
					}
				}
				// rental book selection
				System.out.println("�뿩�� å�� �����ϼ���.");
				int booknum = sc.nextInt();
			
				// �뿩�� ���� ����
				for(int i=0, j=0; i<bookArr.length; i++) {
					if ((bookArr[i][1] != null) && (bookArr[i][4] == null)) {
						j += 1;
						if (booknum == j) {
							bm.bookselect = bookArr[i][0];
							System.out.println("�뿩�� ������ " + bookArr[i][1] + "�� �����߽��ϴ�.");
							bookArr[i][4] = bm.memberselect;
							//�뿩���� �Ⱓ ���
							Calendar cal = new GregorianCalendar();
							Date today = new Date();
							Date returnday = new Date();
							cal.setTime(today);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
							//String now = sdf.format(today);
							bookArr[i][5] = sdf.format(today);
							//System.out.println("today : " + sdf.format(today));
							cal.add(Calendar.DATE, 14);
							returnday = cal.getTime();
							bookArr[i][6] = sdf.format(returnday);
							System.out.println("�ݳ��� ��¥�� " + sdf.format(returnday) + "�Դϴ�.");
							// ����ڴ뿩��Ȳ ����Ʈ�� �߰�
						}
					}
				}
			
			} else if (selectmem == 2) {
				// ����� ���� ����Ʈ
				System.out.println("�ݳ��� å�� �Ʒ��� �����ϴ�.");
				for(int i=0, j=0; i<bookArr.length; i++) {
					if(bookArr[i][4]==bm.memberselect) {
						j += 1;
						System.out.println(" " + j + ". " + bookArr[i][1] + "\t" + bookArr[i][2] + "\t" + bookArr[i][3]);
					}
				}
				// return book selection
				System.out.println("�ݳ��� å�� �����ϼ���.");
				int booknum = sc.nextInt();
				for(int i=0, j=0; i<bookArr.length; i++) {
					if (bookArr[i][4]==bm.memberselect) {
						j += 1;
						if (booknum == j) {
							// �ݳ��� ���� ����
							bm.bookselect = bookArr[i][0];
							System.out.println(" �ݳ��� å���� " + bm.bookselect + "�� �����߽��ϴ�.");
							bookArr[i][4] = null;
							bookArr[i][5] = null;
							bookArr[i][6] = null;
						}
					}
				}
				for(int i=0, j=0; i<bookArr.length; i++) {
					if(bookArr[i][4]==bm.memberselect) {
						j += 1;
						System.out.println(" " + j + ". " + bookArr[i][1] + "\t" + bookArr[i][2] + "\t" + bookArr[i][3]);
					}
				}
			
			} else if (selectmem ==3) {
				// End the system
				exit = true;
				//System.out.println("���α׷��� �����մϴ�.");
				//System.exit(0);
			} else {
			
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

}
