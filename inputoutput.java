package BookManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import json.Car;

import static BookManagement.BookManag.BookDBBuild;
import static BookManagement.BookManag.MemberDBBuild;

public class inputoutput {
    public static Object name;

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM YYYY HH:mm:ss z", Locale.US);
        SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a", Locale.US);
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Auth> authList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Borrow> borrowList = new ArrayList<>();
        BookManag bm = new BookManag();
        bm.MemberDBBuild(memberList, authList);
        bm.BookDBBuild(bookList, borrowList);

        String booklist = bookList.toString();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter("book.txt"));

        bWriter.write(booklist.toString());
        bWriter.close();
        String temp1 = "";
        String reader1 = "";
        BufferedReader bReader1 = new BufferedReader(new FileReader("book.txt"));
        while ((temp1 = bReader1.readLine()) != null) {
            reader1 += temp1 + "\n";
        }
        System.out.println(reader1);

        ArrayList<Book> bookList2 = new ArrayList<>();

        JsonParser p = new JsonParser();
        JsonElement element = p.parse(reader1);

        JsonArray jArray = element.getAsJsonArray();
        for (JsonElement e : jArray) {
            JsonObject o = e.getAsJsonObject();
            Book b = new Book();
            b.setBookid(o.get("bookid").getAsInt());
            b.setTitle(o.get("title").getAsString());
            b.setAuthor(o.get("author").getAsString());
            b.setPublisher(o.get("publisher").getAsString());

            bookList2.add(b);
            System.out.println(b.toString());

        }
        /////////////
        String borrowlist = borrowList.toString();
        BufferedWriter bWriter2 = new BufferedWriter(new FileWriter("borrow.txt"));

        bWriter2.write(borrowlist.toString());
        bWriter2.close();

        String temp2 = "";
        String reader2 = "";
        BufferedReader bReader2 = new BufferedReader(new FileReader("borrow.txt"));
        while ((temp2 = bReader2.readLine()) != null) {
            reader2 += temp2 + "\n";
        }
        System.out.println(reader2);

        ArrayList<Borrow> borrowList2 = new ArrayList<>();
        JsonParser p2 = new JsonParser();
        JsonElement element2 = p2.parse(reader2);
        JsonArray jArray2 = element2.getAsJsonArray();
        for (JsonElement e1 : jArray2) {
            JsonObject o1 = e1.getAsJsonObject();
            Borrow b2 = new Borrow();
            b2.setBookId(o1.get("bookId").getAsInt());
            b2.setStatus(o1.get("status").getAsBoolean());
            b2.setMemberId(o1.get("memberId").getAsInt());

            String o4 = "";
            String o3 = "";
            System.out.println(o1.get("startDay"));
            if ((o1.get("startDay")) != null) {
                o4 = o1.get("startDay").getAsString();
                b2.setStartDay(sdf2.parse(o4));
                o3 = o1.get("returnDay").getAsString();
                b2.setReturnDay(sdf2.parse(o3));

            } else {
                Date o5 = null;
                Date o6 = null;
                b2.setStartDay(o5);
                b2.setReturnDay(o5);

            }

            borrowList2.add(b2);
            System.out.println(b2.toString());

        }
        //////////////////////////////
        String memberlist = memberList.toString();
        BufferedWriter bWriter3 = new BufferedWriter(new FileWriter("member.txt"));

        bWriter3.write(memberlist.toString());
        bWriter3.close();

        String temp3 = "";
        String reader3 = "";
        BufferedReader bReader3 = new BufferedReader(new FileReader("member.txt"));
        while ((temp3 = bReader3.readLine()) != null) {
            reader3 += temp3 + "\n";
        }
        System.out.println(reader3);

        ArrayList<Member> memberList2 = new ArrayList<>();

        JsonParser p3 = new JsonParser();
        JsonElement element3 = p3.parse(reader3);

        JsonArray jArray3 = element3.getAsJsonArray();
        for (JsonElement e3 : jArray3) {
            JsonObject o2 = e3.getAsJsonObject();
            Member m1 = new Member();
            m1.setId(o2.get("id").getAsInt());
            m1.setName(o2.get("name").getAsString());
            String o6= "";
            o6 = o2.get("birth").getAsString();
            m1.setBirth(sdf3.parse(o6));
            memberList2.add(m1);
            System.out.println(m1.toString());
        }

        String authlist = authList.toString();
        BufferedWriter bWriter4 = new BufferedWriter(new FileWriter("auth.txt"));

        bWriter4.write(authlist.toString());
        bWriter4.close();
        String temp4 = "";
        String reader4 = "";
        BufferedReader bReader4 = new BufferedReader(new FileReader("auth.txt"));
        while ((temp4 = bReader4.readLine()) != null) {
            reader4 += temp4 + "\n";
        }
        System.out.println(reader4);
        ArrayList<Auth> authList2 = new ArrayList<>();

        JsonParser p4 = new JsonParser();
        JsonElement element4 = p4.parse(reader4);

        JsonArray jArray4 = element4.getAsJsonArray();
        for (JsonElement e4 : jArray4) {
            JsonObject o3 = e4.getAsJsonObject();
            Auth a1 = new Auth();
            a1.setMemberId(o3.get("memberId").getAsInt());
            a1.setPw(o3.get("pw").getAsString());
            a1.setUserId(o3.get("userId").getAsString());
            authList2.add(a1);
            System.out.println(a1.toString());
        }

//        System.out.println(memberList.toString());
//        System.out.println(authList.toString());
//        System.out.println(bookList.toString());
//        System.out.println(borrowList.toString());
    }

    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }

}
