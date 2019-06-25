package BookManagement;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Login {
    final private static String pattern1 = "^[0-9]*$";

    public static void main(String[] args)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
        ArrayList<Member> studentList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat transFormat = new SimpleDateFormat("yy-MM-dd");
        System.out.println("추가하고싶은 멤버수를 입력하세요 ");
        int k = scan.nextInt();
        for (int i = 5; i < k + 5; i++) {
            Member stu = new Member();
            stu.setId(i);
            System.out.println("이름을 입력하세요 ");
            String name = scan.next();
            System.out.println("생일을 입력하세요 ");
            boolean validation = false;
            String birth2 = "";
            while (!validation) {
                String birth1 = scan.next();
                validation = birth1.matches(pattern1);
                if (validation && birth1.length() == 6) {

                    birth2 = birth1;
                } else {
                    System.out.println("6자리의 숫자만을 입력하세요 .");
                    birth2 = birth1;
                    validation = false;

                }
            }
            Date birth = stringtodate(birth2);

            System.out.println("등록하고자하는 id를 입력하세요");
            String id = scan.next();
            stu.setName(name);
            stu.setBirth(birth);
            studentList.add(stu);

            Auth auth = new Auth();
            auth.setMemberId(i);// 1

            System.out.println("등록하고자하는 pw를 입력하세요");
            String pw = scan.next();

            auth.setUserId(id);
            String pw1 = pw;
            auth.setPw(convertToSha2(pw1));
            authList.add(auth);
        }
        scan.nextLine();


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

    private static Date stringtodate(String date) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("yy-MM-dd");
        String beforechange = date.substring(0, 2) + "-" + date.substring(2, 4) + "-" + date.substring(4, 6);
        Date birth = transFormat.parse(beforechange);
        return birth;
    }
}