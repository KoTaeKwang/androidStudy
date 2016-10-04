package com.example.rhxorhkd.myservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),MyService.class);
        intent.putExtra("command","start"); //service의 onstartcommand 로 간다.
        startService(intent);
    }
}
