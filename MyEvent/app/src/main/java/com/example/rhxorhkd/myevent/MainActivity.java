package com.example.rhxorhkd.myevent;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);


        Button button = (Button)findViewById(R.id.button); //inflation 위의 코드에서 자동으로 되 찾을수 있어
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 textView.setText("버튼이 클릭되었습니다.");
            }
        });
    */
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    textView.setText("손가락이 눌렸습니다.");
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    textView.setText("손가락이 떼졌습니다.");
                }
                return true; //정상적으로 됬다.
            }
        });

        detector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.setText("onScroll() 호출됨 :  "+distanceX+" , "+distanceY);
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView.setText("onFling() 호출됨 : "+velocityX+" , "+velocityY);
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(detector!=null){
            return detector.onTouchEvent(event);
        }else{
            return super.onTouchEvent(event);
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"onBackPressed() 호출됨",Toast.LENGTH_LONG).show();
        return;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){ //가로방향으로 돌렸을때
            Toast.makeText(getApplicationContext(),"가로방향으로 됨",Toast.LENGTH_LONG).show();
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){//세로방향으로 돌렸을때
            Toast.makeText(getApplicationContext(),"세로방향으로 됨",Toast.LENGTH_LONG).show();
        }
        super.onConfigurationChanged(newConfig);
    }
}
