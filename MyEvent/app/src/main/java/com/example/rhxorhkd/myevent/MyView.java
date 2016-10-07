package com.example.rhxorhkd.myevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rhxorhkd on 2016-10-05.
 */

public class MyView extends View {

    public MyView(Context context) {  //뷰를 상속받은 클래스는 무조건 생성자가 2개 필요해
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("MyView","손가락이 눌렸습니다.");
        }else if(event.getAction()==MotionEvent.ACTION_UP){
            Log.d("MyView","손가락이 떼졌습니다.");
        }else if(event.getAction()==MotionEvent.ACTION_MOVE){
            Log.d("MyView","손가락이 움직입니다.");
        }
        return true; //정상적으로 됬다.
    }
}
