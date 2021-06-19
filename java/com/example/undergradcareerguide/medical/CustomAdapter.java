package com.example.undergradcareerguide.medical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.undergradcareerguide.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList num;
    String[] uniList;


    public CustomAdapter(Context context, ArrayList num, String[] uniList) {
        this.context = context;
        this.num = num;
        this.uniList = uniList;

    }

    @Override
    public int getCount() {
        return this.uniList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        v= LayoutInflater.from(this.context).inflate(R.layout.list_view_items,parent,false);
        TextView names = v.findViewById(R.id.TextView2);
        TextView num = v.findViewById(R.id.TextView1);

        names.setText(this.uniList[position]+"");
        num.setText(this.num.get(position)+"");

        return v;

    }
}
