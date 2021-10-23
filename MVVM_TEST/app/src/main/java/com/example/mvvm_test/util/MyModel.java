package com.example.mvvm_test.util;

//DB 나 네트워크 연결 역할을 한다.
// Atcs as our Database or Network(Cloud Storage)
// This is our model
public class MyModel {
    // 총 3개의 생성자
    String waterName;
    int number;
    int price;

//    2. Constructor 생성

    public MyModel(String waterName, int number, int price) {
        this.waterName = waterName;
        this.number = number;
        this.price = price;
    }

    //1. getter and setter
    public String getWaterName() {
        return waterName;
    }

    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
