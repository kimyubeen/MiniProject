package day0624;



import java.util.Scanner;

public class JavaMini {
   
    
   
   
   public static void main(String[] args) {
      String id = "������";
      String pw = "1234";
      
      Scanner sc = new Scanner(System.in);
      System.out.println("ID/PassWard �Է��ϼ���.");
      id=sc.next();
      pw=sc.next();
      
     
      
          if(!id.equals("������")) {
             System.out.println("ȸ�������� �����ϴ�.");
          }else if(!pw.equals("1234")){
             System.out.println("��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
          }else {
             System.out.println("�α��� �Ǿ����ϴ�.");
          }
   }
}