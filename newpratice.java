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
        // database�� ���� ������
        // ArrayList�� �׽�Ʈ �����͸� �߰��ϴ� for��
        Scanner scan = new Scanner(System.in);
        System.out.println("�߰��ϰ���� ������� �Է��ϼ��� ");
        int k = scan.nextInt();
        for (int i = 0; i <k ; i++) {
            Student stu = new Student();
            System.out.println("�̸��� �Է��ϼ��� ");
            String name = scan.next();
            System.out.println("������ �Է��ϼ��� ");
            boolean validation = false;
            String birth = "";
            while(!validation) {
                String birth1 = scan.next();
                validation = birth1.matches(pattern1);
                if(validation) {
                    
                    birth = birth1;
                }else {
                    System.out.println("���ڸ��� �Է��ϼ��� .");
                    birth = birth1;
                }
              }  
            System.out.println("id�� �Է��ϼ���");
            String id = scan.next();
            stu.setId(id);//1
            stu.setName(name);
            stu.setBirthdate(birth);
            studentList.add(stu);
            
            
            Auth auth = new Auth();
            auth.setStudentId(id);//1
            
            System.out.println("pw�� �Է��ϼ���");
            String pw = scan.next();
           
            auth.setUserId(id);
            String pw1 = pw ;
            auth.setPw(convertToSha2(pw1));
            authList.add(auth);
        }
        scan.nextLine();
       
        System.out.println("id�� �Է����ּ���: ");
        String id = scan.nextLine();
        
        System.out.println("��й�ȣ�� �Է����ּ���: ");
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
            System.out.println("�л� �̸�: " + logInUser.getName() + ", ����: " + logInUser.getBirthdate());
        } else {
            System.out.println("�α��� ����");
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

           