package com.example.rhxorhkd.mylayoutinflater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){

        SubLayout layout1 = new SubLayout(this);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(layout1);


        /*
        LinearLayout container = (LinearLayout) findViewById(R.id.container); // 앞에서 setcontentview 를 했으니까 여기서 찾아줄 수 잇어
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //시스템 서비스 객체를 참조할 수 있다.
        inflater.inflate(R.layout.sub_layout,container,true);  //수동으로 인플레이션 할 수있어   //첫번째 것을 두번째에 넣는거야

       Button button2 = (Button)container.findViewById(R.id.button2);  //container 안에 있는걸 찾을수 있는거야

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"부분화면의 버튼클릭됨",Toast.LENGTH_LONG).show();
            }
        });
        */

    }
}
