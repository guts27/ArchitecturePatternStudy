package com.example.mvvm_test.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm_test.R;

public class MainActivity extends AppCompatActivity{

    Button btn;
    TextView textView;

    //6. 메인액티비티와 뷰 모델을 연결한다. 그리고 라이브 데이터를 듣는다.
    // 라이브 데이터는 뷰모델 안에 있으며, 뷰 모델은 데이터를 나에게 전달할 책임이 없다. 내가 데이터를 관찰해 얻는다.
    AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        textView = findViewById(R.id.textView);
        final ImageView imageView = findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                appViewModel.getWaterName();
            }
        });

        // 메인 액티비티는 배포된 물을 갖는데 책임이 있다. == 메인액티비티는 뷰모델을 통해 라이브 데이터를 갖는데 책임이 있다.
        // 그래서 라이브 데이터를 듣는데에도 책임이 있다.
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        //7 - Listening & observing 라이브 데이터의 변화를
        //뷰모델은 데이터를 너에게 줄 의무가 없어 - 그러나 메인액티비티는 데이터를 얻을 의무가 있어 그래서 변화를 감시한다.
        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //그래서 뮤터블 라이브 데이터에 접근하고 어떤 변화든 탐지한다.
                //그래서 어떤 변화든 발생하면 텍스트를 체인지한다.
                textView.setText(s);
                btn.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
            }
        });

    }



    //MVVM
    // we need to make the connection "Binding" - "ViewModel"
    // 왜 라이브 데이터가 필요한가요? - mutable과 다르ㅓㅁ
    //벤딩머신은 물을 주기는 하는데 너한테 줄 책임은 없어 - 뷰모델은 데이터를 너에게 줄 의무가 없어 - 그러나 메인액티비티는 데이터를 얻을 의무가 있어 벼ㅑㄴ화를 감지하고
    //뷰모델 프로바이더도 써야 해서 라이프사이클익스텐션 디펜던시에 추가해야함
    // appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
    //instead of using deprecated methods를 해서 오류 해결
   // appViewModel = new ViewModelProvider(this).get(AppViewModel.class);
    //1-Implemㄷnting the dependency of ViewModel
    // 2- Creating ViewModel Class


    //내가 밴딩머신한테 물달라 홰
    //라이브 데이터 뷰모델 안에 있음, 뷰모델은데이터를 나에게 딜리버링할 책임이 없어 단지, 얻는거야 디스플레잉 데이터 뮤터블라이브데이터
    //6 - Connecting MainActivity with ViewModel and Listening to LIVE Data
}
//
//   appViewModel.mutableLiveData.observe(this, new Observer<String>() {
//@Override
//public void onChanged(String s) {
//        //그래서 뮤터블 라이브 데이터에 접근하고 어떤 변화든 탐지한다.
//        //Any Change in the live data do this;
//        //그래서 어떤 변화든 발생하면 여기로 감 텍스트 체인지
//        textView.setText(s);
//        //메인액티비티는 디비와 연결될 의무가 없다.
//        }
//        });
//
//        }