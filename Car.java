package json;

import com.google.gson.Gson;

public class Car {
    // ���⿡ �����Ͱ� ��ϵ� ���� ����
    public int carNum;
    // ���� ��ȣ
    public String carPlateNum;
    // ���� ����
    public String carColor;
    // ���� ����
    public String carType;

    // ���� ����
    public int carYear;

    public void start() {
        System.out.println("���� ���");
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }

}
