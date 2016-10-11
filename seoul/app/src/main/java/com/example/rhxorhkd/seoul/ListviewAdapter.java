package com.example.rhxorhkd.seoul;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rhxorhkd on 2016-10-08.
 */

public class ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Listviewitem> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<Listviewitem> data){
        this.inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        Log.d("layout",""+position);
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
            convertView = inflater.inflate(layout,parent,false);

        Listviewitem listviewitem = data.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.lay_imageview);
        icon.setImageResource(listviewitem.getIcon());

        TextView name = (TextView)convertView.findViewById(R.id.lay_textview);
        name.setText(listviewitem.getName());

        Log.d("layout","position : "+position);
        Log.d("layout",""+listviewitem.getName());

        return convertView;
    }
}
