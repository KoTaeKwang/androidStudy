package com.example.rhxorhkd.myfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onFragmentChanged(int index){
        if(fragment2==null){
            fragment2 = new Fragment2();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container1,fragment2).commit();
    }
}
