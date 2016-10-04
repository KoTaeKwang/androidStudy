package com.example.rhxorhkd.mylayoutinflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by rhxorhkd on 2016-10-04.
 */

public class SubLayout extends LinearLayout{ //뷰를 extends하면 생성자는 적어도 2개 만들어야해
    public SubLayout(Context context) {
        super(context);
        init(context);
    }

    public SubLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub_layout,this,true); //해당 레이아웃이 이 클래스에 붙음
    }
}
