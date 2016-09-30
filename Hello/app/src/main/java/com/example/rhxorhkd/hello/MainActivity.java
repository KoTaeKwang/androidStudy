package com.example.rhxorhkd.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){ // activity_main.xml 에서  button 의 properties 에 onButton1Clicked 를 생성했기때문에  똑같은 이름의 함수를 생성함
        Toast.makeText(this,"버튼이 클릭되었습니다.",Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);  // -> naver 로 이동
    }

    public void onButton3Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-5011-0822"));
        startActivity(intent);  // -> 전화 걸기 화면으로 이동
    }

    public void onButton4Clicked(View v){
        Intent intent =new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}
