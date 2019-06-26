package json;

import com.google.gson.Gson;

public class Car {
    // 여기에 데이터가 등록된 고유 순서
    public int carNum;
    // 차량 번호
    public String carPlateNum;
    // 차량 색깔
    public String carColor;
    // 차량 종류
    public String carType;

    // 차량 연식
    public int carYear;

    public void start() {
        System.out.println("차량 출발");
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }

}
