package login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class newpratice {
    final private static String pattern1= "^[0-9]*$";
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        // database가 없기 때문에
        // ArrayList에 테스트 데이터를 추가하는 for문
        Scanner scan = new Scanner(System.in);
        System.out.println("추가하고싶은 멤버수를 입력하세요 ");
        int k = scan.nextInt();
        for (int i = 0; i <k ; i++) {
            Student stu = new Student();
            System.out.println("이름을 입력하세요 ");
            String name = scan.next();
            System.out.println("생일을 입력하세요 ");
            boolean validation = false;
            String birth = "";
            while(!validation) {
                String birth1 = scan.next();
                validation = birth1.matches(pattern1);
                if(validation) {
                    
                    birth = birth1;
                }else {
                    System.out.println("숫자만을 입력하세요 .");
                    birth = birth1;
                }
              }  
            System.out.println("id를 입력하세요");
            String id = scan.next();
            stu.setId(id);//1
            stu.setName(name);
            stu.setBirthdate(birth);
            studentList.add(stu);
            
            
            Auth auth = new Auth();
            auth.setStudentId(id);//1
            
            System.out.println("pw를 입력하세요");
            String pw = scan.next();
           
            auth.setUserId(id);
            String pw1 = pw ;
            auth.setPw(convertToSha2(pw1));
            authList.add(auth);
        }
        scan.nextLine();
       
        System.out.println("id를 입력해주세요: ");
        String id = scan.nextLine();
        
        System.out.println("비밀번호를 입력해주세요: ");
        String pw = scan.nextLine();
        Student logInUser = new Student();
        for (Auth a : authList) {
        
            if (a.getUserId().equals(id)) {
                if (convertToSha2(pw).equals(a.getPw())) {
                    for (Student s : studentList) {
                        if (s.getId().equals(a.getStudentId())) {
                            logInUser = s;
                            break;
                        }
                    }
                }
            }
        }
        if (logInUser.getName() != null) {
            System.out.println("학생 이름: " + logInUser.getName() + ", 생일: " + logInUser.getBirthdate());
        } else {
            System.out.println("로그인 실패");
        }
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
    
    
}

           