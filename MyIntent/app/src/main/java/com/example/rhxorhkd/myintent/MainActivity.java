package com.example.rhxorhkd.myintent;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_MENU =1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        //Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-5011-0822"));
        //startActivity(intent);

        //Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        //startActivityForResult(intent,REQ_MENU); //응답 받으려면 ForResult 적어 , 1001 은 메뉴화면을 띄었을때 요청 코드

        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.example.rhxorhkd.myintent","com.example.rhxorhkd.myintent.MenuActivity"); //동적으로 처리하고 싶을때
        intent.setComponent(name);
        intent.putExtra("title","소녀시대");
        intent.putExtra("age",20);

        Person person01 = new Person("한지민",21);
        intent.putExtra("person",person01); //serializable 하면  용량이 커질 수 있어서  parcelable 로 이용을 한다.  일반적으로는 serializable 로해


        startActivityForResult(intent,REQ_MENU);
    }
}
