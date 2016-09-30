package com.example.rhxorhkd.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButton1Clicked(View v){
        finish();  // 닫는 기능    안드로이드는 main 켜지고 menu 켜지므로   menu 가 main acitivity 앞에 있으므로  finish 하면  main activity가 나타나.
    }
}
