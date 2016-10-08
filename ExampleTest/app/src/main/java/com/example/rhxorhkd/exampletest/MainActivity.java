package com.example.rhxorhkd.exampletest;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent;
        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
         tabHost.setup(getLocalActivityManager());  //intent를 content로 하기위해서는 getlocalactivitymanager 필요
        TabHost.TabSpec spec;

        //setindicator -> 탭의 지시자로, 라벨과 아이콘 지정 . setIndicator(CharSequence label, Drawable icon)
        //setContent -> 탭의 내용물 XML 문서의 뷰를 이용 , setContent(Intent intent) -> 인텐트를 이용하여 다른 액티비티 호출
        intent = new Intent(this,home.class);
         spec = tabHost.newTabSpec("Tab1").setContent(intent).setIndicator(getString(R.string.tab1));
        tabHost.addTab(spec);

        intent =new Intent(this,checkin.class);
        spec = tabHost.newTabSpec("Tab2").setContent(intent).setIndicator(getString(R.string.tab2));
        tabHost.addTab(spec);

        intent =new Intent(this,rank.class);
         spec = tabHost.newTabSpec("Tab3").setContent(intent).setIndicator(getString(R.string.tab3));
        tabHost.addTab(spec);

        intent =new Intent(this,set.class);
        spec = tabHost.newTabSpec("Tab4").setContent(intent).setIndicator(getString(R.string.tab4));
        tabHost.addTab(spec);

        //높이 설정
        /*tabHost.getTabWidget().getChildAt(0).getLayoutParams().height=80;
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height=80;
        tabHost.getTabWidget().getChildAt(2).getLayoutParams().height=80;
        tabHost.getTabWidget().getChildAt(3).getLayoutParams().height=80;*/

        tabHost.setCurrentTab(0);

    }
}
