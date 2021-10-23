package com.example.mvc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button chooseWater;
    TextView getWater;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 선택시 물을 선택하고 결제하는 과정이 시작됨
        chooseWater = findViewById(R.id.button);

        //결제한 물의 종류, 개수, 가격
        getWater = findViewById(R.id.textView);

        imageView = findViewById(R.id.imageView);

        chooseWater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DisplayAppinText();
            }
        });
    }

    public MyModel GetAppFromModel(){
        return new MyModel("제주 삼다수", 1, 1000);
    }

    public void DisplayAppinText(){
        //텍스트 업데이트, Model으로 부터 가져와
        getWater.setText(GetAppFromModel().getWaterName() + " 개수: " + GetAppFromModel().getNumber() + " 가격: " + GetAppFromModel().getPrice());
        imageView.setVisibility(View.VISIBLE);
        chooseWater.setVisibility(View.INVISIBLE);
    }

    // MVC Pattern
    // View: TextView&Button(MainActivity)
    // Model: MyModel class
    // Controller: MainActivity
}
// 1- Implementing MVC Pattern
// 그는 냉장고 여는거 사는거 모든것을 다 스스로 한다.
// We need to create a button that when the user
// clicked it, it will display text in textview(텍스트 내부에 메시지를 표시하는 버튼을 생성)
//(텍스트를 업데이트 하고 텍스트 내부에 새 텍스트를표시)
// MVC는 컨트롤러와 접촉하는 뷰가 있따.->컨트롤러가 모델에 접촉한다. -> 모델은 컨트롤러에 데이터를 주고 -> 컨트롤러는 뷰를 엄데이트 한다.
// 리스너?구현의 두가지 방법 1. xml을 사용해서 메소드 생성을 전달하는것 메소드 내부에 뷰를 전달
//2. Mymodel에 생성?