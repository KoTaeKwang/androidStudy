package com.example.rhxorhkd.exampletest;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
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

        ArrayList<Listviewitem> data = new ArrayList<>();
        Listviewitem one = new Listviewitem(R.drawable.ic_launcher,"one");
        Listviewitem two = new Listviewitem(R.drawable.ic_launcher,"two");
        Listviewitem three = new Listviewitem(R.drawable.ic_launcher,"three");

        data.add(one);
        data.add(two);
        data.add(three);

        final ListviewAdapter adapter = new ListviewAdapter(this,R.layout.item,data); //어댑터 만들고
        listView.setAdapter(adapter); //listview에 어댑터 ㄱㄱ

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
