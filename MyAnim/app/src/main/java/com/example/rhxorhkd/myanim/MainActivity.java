package com.example.rhxorhkd.myanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.textView);
    }

    public void onButton1Clicked(View v){
        Animation tranlate = AnimationUtils.loadAnimation(this,R.anim.translate);
        //textview.startAnimation(tranlate);
        ViewGroup container = (ViewGroup)findViewById(R.id.activity_main);
        container.startAnimation(tranlate);
    }

}
