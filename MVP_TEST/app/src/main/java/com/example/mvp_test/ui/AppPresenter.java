package com.example.mvp_test.ui;

import com.example.mvp_test.util.MyModel;

//프레젠터의 역할을 하는 클래스
// : 웨이터
public class AppPresenter {
    // 1. 프레젠터와 뷰(메인액티비티) 사이의 연결은 인터페이스에의해서 수행되어진다.
    AppView appView;

    public AppPresenter(AppView appView){
        this.appView = appView;
    }

    //2. 프레젠터와 모델 사이의 연결
    public MyModel GetAppFromModel(){
        return new MyModel("WATER", 1, 1000);
    }

    // 3. 프레젠터와 메인액티비티 사이의 연결(인터페이스를 호출하여)
    public void getWaterName(){
        appView.onGetWatername(GetAppFromModel().getWaterName()/********passing here the results from DB***********/);

    }
    //프레젠터는 모델에 가서 데이터 얻어서 다시 돌아온 후 그걸 다룸
    // 내가 웨이터에게 워터를 요청 하면
    // 프레젠터는 = 웨이터가 냉장고(디비)가서 물 가져옴
}
//This will acts as Presenter [The Waiter];)
// 1- The Link between Presenter and the view(MainActivity) is done by
//Interface

//Link instance
//2- Linkage between presenter and Model
//3.Linkage Between presenter and MainActivity (Calling The interface)