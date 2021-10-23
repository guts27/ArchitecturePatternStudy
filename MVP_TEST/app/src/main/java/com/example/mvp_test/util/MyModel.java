package com.example.mvp_test.util;

//DB 나 네트워크 역할을 한다.

public class MyModel {

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

    public void setWaterName(String appName) {
        this.waterName = waterName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int appDownloads) {
        this.number = number;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int appRating) {
        this.price = appRating;
    }
}

// Atcs as our Database or Network(Cloud Storage)
// This is our model