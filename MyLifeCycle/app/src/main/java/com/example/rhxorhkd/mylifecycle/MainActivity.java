package com.example.rhxorhkd.mylifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"onCreate 호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(getApplicationContext(),"onStop 호출됨",Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(),"onDestroy 호출됨",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(),"onStart 호출됨",Toast.LENGTH_LONG).show();
        super.onStart();
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(),"onPause 호출됨",Toast.LENGTH_LONG).show();
        saveScore();   //갑자기 전화온 상황에 점수를 저장해야한다.
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"onResume 호출됨",Toast.LENGTH_LONG).show();
        loadScore(); //다시 켜면 점수를 가져온다.
        super.onResume();
    }

    private void saveScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE); //SharedPreferences 많이 사용한다. 간단하게 한두가지 저장할 때 사용하는거야
        SharedPreferences.Editor editor = pref.edit(); //editor 를 만들어서 저장할 수 있다.
        editor.putInt("score",10000);
        editor.commit();
    }
    private void loadScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        int score = pref.getInt("score",0); //값이없으면 0을 넣어줘
        Toast.makeText(getApplicationContext(),"loaded score : "+score,Toast.LENGTH_LONG).show();
    }


}
