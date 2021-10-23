package com.example.mvvm_test.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_test.util.MyModel;

public class AppViewModel extends ViewModel {

//    //4 - Live Data
// 뮤터블 라이브 데이터가 필요하다.
//Live Data vs MutableLiveData
//Mutable: we can post and set the live data
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    // 3-뷰 모델고 모델 연결
    private MyModel getAppFromDatabase(){
        return new MyModel("Water", 1, 1000);
        // 전달 책임은 없다. 가져오면 메인 액티비티가 뮤터블 라이브 데이터를 통해 볼것이다.
        // 자판기는 누르기만 하면 누구나 가져갈 수 있다. 하지만 나는 물병을 가져가야 하기에 라이브 데이터를 통해 뷰모델에 요청하고 확인하다.
    }

    //벤딩머신은 무엇을 가져갈지 표시함, 디스플레이랑 배포도
    // 5 - 뷰모델과 메인 액티비티연결
    public void getWaterName(){//가장 최근 데이터를 가져올수있음
        String waterName = getAppFromDatabase().getWaterName(); // 컨넥션이 아니라 져스트 쇼잉 디스플레잉 라이브데이터를
        mutableLiveData.setValue(waterName);//자판기가 음료 배포
        //모든 사람에게 물 배포 가능
    }
}







//
//
//public class AppViewModel extends ViewModel {
//
//    //    //4 - Live Data
////    LiveData<String> liveData;우리는 얘가 아니라 뮤터블이 필요함 왜냐면 셋엔 포스트 라이브데이터 하려고
//    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
//    // 3- Connectinf ViewModel with DATABASE - (MODEL)
//    //뷰몰데과 디비 연결
//    private MyModel getAppFromDatabase(){
//        return new MyModel("Master Coding App", 9034, 4);
//        // 전달 책임은 없어 져스트 뷰잉 게팅 데이터 하지만 넌 가져와야해 그래서 메인액티비티가 들을거야 요청이랑 라이브 데이터를 뷰모델로부터-> 4
//        //벤딩 머신은 딜리버리 응단 너에게 하지 않음 누르기만 하면 누구나 가져갈수있어   딜리버링 응답 안해 져스트 데이터 수집 하지만 너는 갖는데 책임이 있어
//        //그래서 메인액티비티가 라이브 데이타 들억서 뷰모델로 부터 요청?해
//
//        //Live Data vs MutableLiveData
//        //Mutable: we can post and set the live data
//    }
//    //벤딩머신은 무엇을 가져갈지 표시함, 디스플레이랑 배포도
//    // 5 - Connecting View<odel with MainActivity(VIEW)
//    public void getAppName(){//가장 최근 데이터를 가져올수있음
//        String appName = getAppFromDatabase().getAppName(); // 컨넥션이 아니라 져스트 쇼잉ㅇ 디스플레잉이라는디 라이브데이터를
//        mutableLiveData.setValue(appName);//져스트 자판기가 음료 배포
//        //모든 사람에게 물 배포 가능
//    }
//}
