package com.example.undergradcareerguide.UsersData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.undergradcareerguide.R;

import java.util.ArrayList;

public class ListAdapterPC extends BaseAdapter {

    Context context;
    ArrayList<String> Name;
    ArrayList<String> TestName;
    ArrayList<String> CorrectAns;
    ArrayList<String> WrongAns;
    ArrayList<String> Percentage;

    public ListAdapterPC(Context context, ArrayList<String> name, ArrayList<String> testName, ArrayList<String> correctAns, ArrayList<String> wrongAns, ArrayList<String> percentage) {
        this.context = context;
        Name = name;
        TestName = testName;
        CorrectAns = correctAns;
        WrongAns = wrongAns;
        Percentage = percentage;
    }


    @Override
    public int getCount() {
        return WrongAns.size();
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

        TextView Cnic, Name, Email, Pass, Phone;

        LayoutInflater layoutInflater;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = layoutInflater.inflate(R.layout.row_items, null);

        Cnic = v.findViewById(R.id.textViewCnic);
        Name = v.findViewById(R.id.textViewName);
        Email = v.findViewById(R.id.textViewEmail);
        Pass = v.findViewById(R.id.textViewPass);
        Phone = v.findViewById(R.id.textViewPhone);

        Cnic.setText(this.Name.get(position) + "");
        Name.setText(this.TestName.get(position) + "");
        Email.setText(this.CorrectAns.get(position) + "");
        Pass.setText(this.WrongAns.get(position) + "");
        Phone.setText(this.Percentage.get(position) + "");


        return v;

    }
}