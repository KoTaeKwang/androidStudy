package com.example.rhxorhkd.myframelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity { //famelayout ,   imageview 를 중첩으로 쌓아서  버튼클릭으로 이미지가 바뀌게 하는 기능
    ImageView imageview; //onclick 안에서 사용하기위해
    ImageView imageview2;

    boolean selected =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         imageview = (ImageView)findViewById(R.id.imageView);
         imageview2 = (ImageView)findViewById(R.id.imageView2);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected){
                    imageview.setVisibility(View.VISIBLE); //보이게하기
                    imageview2.setVisibility(View.GONE); //안보이게하기
                }
                else{
                    imageview.setVisibility(View.GONE);
                    imageview2.setVisibility(View.VISIBLE);
                }
                selected = !selected;
            }
        });
    }
}
