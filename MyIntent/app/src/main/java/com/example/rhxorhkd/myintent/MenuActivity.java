package com.example.rhxorhkd.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        if(intent!=null){
            String title =intent.getStringExtra("title");
            int age = intent.getIntExtra("age",0); //값이 없으면 0으로
            Person person01 = (Person)intent.getSerializableExtra("person");  // person 객체 받을수 잇어
            Toast.makeText(getApplicationContext(),"person name : "+person01.getName(),Toast.LENGTH_LONG).show();
        }

    }
}
