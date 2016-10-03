package com.example.rhxorhkd.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {  //버튼누를때 두가지 방법 .  1. findViewById -> setOnClickListener  , 2. xml에서 버튼 onClick할때 이름으로

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //xml에서 만든 화면이  설정되는 것이다.

        Button button2= (Button)findViewById(R.id.button2); //앱이 실행이 됬을 때 실제 버튼 객체로 만들어준다. 어디에 있는지 모르므로 find를 해주는거야 , findViewById 가 View로 리턴되므로 (Button)으로 캐스팅
        button2.setOnClickListener(new View.OnClickListener() {//버튼을 클릭했을 때 이벤트를 처리하는 것
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "중지버튼이 눌렸어요",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onButton1Clicked(View v){
        Toast.makeText(getApplicationContext(), "시작버튼이 눌렸어요",Toast.LENGTH_LONG).show();
    }
}
