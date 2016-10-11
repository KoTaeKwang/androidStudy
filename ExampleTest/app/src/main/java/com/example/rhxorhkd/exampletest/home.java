package com.example.rhxorhkd.exampletest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ScrollView scrollView =(ScrollView) findViewById(R.id.sc);
        ListView listView = (ListView)findViewById(R.id.listView);
        Button button12 = (Button)findViewById(R.id.button12);

        ArrayList<Listviewitem> data = new ArrayList<>();
        Listviewitem one = new Listviewitem(R.drawable.ic_launcher,"one");
        Listviewitem two = new Listviewitem(R.drawable.ic_launcher,"two");
        Listviewitem three = new Listviewitem(R.drawable.ic_launcher,"three");

        data.add(one);
        data.add(two);
        data.add(three);

        final ListviewAdapter adapter = new ListviewAdapter(this,R.layout.item,data); //어댑터 만들고
        listView.setAdapter(adapter); //listview에 어댑터 ㄱㄱ

        listViewHeightSet(adapter,listView);

        listView.setOnTouchListener(new View.OnTouchListener() { //list touch할때 scrollview 터치 안되게
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //클릭했을때
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)adapter.getItem(position);
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
            }
        });


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("layout","aa");
                SlideUp(scrollView,getBaseContext());
              // slideup 해야해
            }
        });

    }
    public void SlideUp(View view, Context context){
        view.startAnimation(AnimationUtils.loadAnimation(context,R.anim.translate));
    }


    private static void listViewHeightSet(BaseAdapter listAdapter, ListView listView){ //리스트뷰의 아니템 높이와 아이템갯수를 구해서 전체 높이 설정해서 스크롤 뷰안에 높이가 정해진 리스트뷰 넣어줌
        int totalHeight = 0;
        for(int i=0;i<listAdapter.getCount();i++){
            View listItem = listAdapter.getView(i,null,listView);
            listItem.measure(0,0);
            totalHeight+=listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight +(listView.getDividerHeight()*(listAdapter.getCount()-1));
        listView.setLayoutParams(params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_view,menu);
        MenuItem mSearch = menu.findItem(R.id.search);
        //mSearch.expandActionView();

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(mSearch);
        searchView.setIconified(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
               // Log.d("text",query); -> query 찍힘
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }




}
