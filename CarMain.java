package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CarMain {

    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Car myCar = new Car();
        myCar.carColor = "������";
        myCar.carNum = 1;
        myCar.carPlateNum = "00�� 0000";
        myCar.carType = "���";

        Car yourCar = new Car();
        yourCar.carColor = "�Ķ���";
        yourCar.carNum = 2;
        yourCar.carPlateNum = "99�� 9999";
        yourCar.carType = "����";

        ArrayList<Car> carList1 = new ArrayList<>();
        carList1.add(yourCar);
        carList1.add(myCar);

        String str = carList1.toString();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter("car.txt"));

         bWriter.write(str);
        bWriter.close();
//        System.out.println("��");
        String reader = "";
        String temp = "";
        BufferedReader bReader = new BufferedReader(new FileReader("car.txt"));
        while ((temp = bReader.readLine()) != null) {
            reader += temp +"\n" ;
          
        }
        System.out.println(reader);

        ArrayList<Car> carList2 = new ArrayList<>();

        JsonParser p = new JsonParser();
        JsonElement element = p.parse(reader);

        JsonArray jArray = element.getAsJsonArray();
        for (JsonElement e : jArray) {
            JsonObject o = e.getAsJsonObject();
            Car c = new Car();
            c.carColor = o.get("carColor").getAsString();
            c.carNum = o.get("carNum").getAsInt();
            c.carPlateNum = o.get("carPlateNum").getAsString();
            c.carType = o.get("carType").getAsString();

            carList2.add(c);
            System.out.println(c.carNum);
        }
       

        // ȭ�鿡��
        System.out.println("=================���� ��� �ý���======================");
        for (Car c : carList2) {
            System.out.println("���� ��� ����: " + c.carNum);
            System.out.println("���� ��ȣ: " + c.carPlateNum);
            System.out.println("���� ����: " + c.carType);
            System.out.println("���� ����: " + c.carColor);
        }
        System.out.println("carList2: " + carList2);
        // JSON?
        // JavaScript Object Notation
    }

}