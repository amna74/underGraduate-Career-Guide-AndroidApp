package com.example.undergradcareerguide.medical;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;

import java.util.ArrayList;

public class FieldCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList num;
    String fieldList[][];
    int selectPos;
   public static String namesss;

    public FieldCustomAdapter(Context context, ArrayList num, String fieldList[][],int selectPos) {
        this.context = context;
        this.num = num;
        this.fieldList = fieldList;
        this.selectPos=selectPos;
    }


    @Override
    public int getCount() {
        return num.size();
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

        names.setText(this.fieldList[selectPos][position]+"");
        names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fieldK=0;
                fieldK=position;
                namesss=fieldList[selectPos][position]+"";
                Intent uniIntent= new Intent(context.getApplicationContext(),UniMedActivity.class);
                uniIntent.putExtra("Uni",String.valueOf(fieldK));
                context.startActivity(uniIntent);
            }
        });
        num.setText(this.num.get(position)+"");

        return v;
    }
}
