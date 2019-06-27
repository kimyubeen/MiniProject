package day0624;



import java.util.Scanner;

public class JavaMini {
   
    
   
   
   public static void main(String[] args) {
      String id = "이유정";
      String pw = "1234";
      
      Scanner sc = new Scanner(System.in);
      System.out.println("ID/PassWard 입력하세요.");
      id=sc.next();
      pw=sc.next();
      
     
      
          if(!id.equals("이유정")) {
             System.out.println("회원정보가 없습니다.");
          }else if(!pw.equals("1234")){
             System.out.println("비밀번호가 일치 하지 않습니다.");
          }else {
             System.out.println("로그인 되었습니다.");
          }
   }
}