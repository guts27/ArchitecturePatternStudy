package com.example.mvp_test.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_test.R;
import com.example.mvp_test.util.MyModel;

public class MainActivity extends AppCompatActivity implements AppView{

    Button btn;
    TextView textView;

    //Linking Activity with Presenter
    AppPresenter appPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//인터페이스는 프레진더톼와 뷰의 미드웨이

        btn = findViewById(R.id.button);

        textView = findViewById(R.id.textView);

        final ImageView imageView = findViewById(R.id.imageView);

        //Instantiaing the presenter
        appPresenter = new AppPresenter(this);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //데이터를 얻기 위해 프레젠터 호출
                // 액티비티와 모델사이의 연결을 없앤다.
                //메인 액티비티는 UI만을 다룬다.
                //그래서 액티비티는 어디에 모델이 있고 어디서 데이터를 얻는지 모름
                //모든 로직은 프레젠터에서만 발생
                appPresenter.getWaterName();
                btn.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);

            }
        });

    }


    @Override
    public void onGetWatername(String string) {
        textView.setText(string);

    }

    // MVP Pattern
    //View: Activity with TextView  & Button
    //Model: MyModel class
    // Presenter: Presenter

    // But, Not use MVC Cuz
}