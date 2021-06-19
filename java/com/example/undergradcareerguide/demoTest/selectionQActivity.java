package com.example.undergradcareerguide.demoTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;

import java.util.Random;

import static com.example.undergradcareerguide.demoTest.DemoJavaTeset.javaQ;

public class selectionQActivity extends AppCompatActivity {

    TextView textView;
    NumberPicker numberPicker,markPicker,TimePicker;
    Button calculate,Proceed;

    static int obmark=1,objnumm=2,subtotal,Objtime=5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_qactivity);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen


        numberPicker= findViewById(R.id.quesPicker);
        markPicker= findViewById(R.id.markPicker);
        TimePicker= findViewById(R.id.TimePicker);
        calculate= findViewById(R.id.calculate);
        Proceed= findViewById(R.id.proceed);
        textView=findViewById(R.id.TotalTextView);

        numberPicker.setMinValue(2);
        numberPicker.setMaxValue(250);

        markPicker.setMinValue(1);
        markPicker.setMaxValue(5);

        TimePicker.setMinValue(5);
        TimePicker.setMaxValue(1000);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                objnumm=newVal;

            }
        });

        markPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                obmark=newVal;

            }
        });

        TimePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Objtime=newVal;
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);

                subtotal = objnumm * obmark;
                textView.setText("Total Marks = " + subtotal);
                Proceed.setVisibility(View.VISIBLE);
            }
        });

        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(selectionQActivity.this, "Proceeding....", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NTest.class);
                startActivity(intent);

            }
        });





    }

    public void btn_LearnMore(View view) {
        String jerry="https://23apps.com/quiz-app";
        Uri webaddress =Uri.parse(jerry);
        Intent gotojerry = new Intent(Intent.ACTION_VIEW,webaddress);
        if (gotojerry.resolveActivity(getPackageManager())!=null)
        {
            startActivity(gotojerry);
        }
        else
        {
            Toast.makeText(this, "Does Not Exist", Toast.LENGTH_SHORT).show();
        }

    }

    public void btn_jerryAxe(View view) {
        String axe = "http://www.instagram.com/jerry_axe/";
        Uri insta = Uri.parse(axe);
        Intent gotoInsta = new Intent (Intent.ACTION_VIEW,insta);
        if (gotoInsta.resolveActivity(getPackageManager())!=null)
        {
            startActivity(gotoInsta);
        }
        else
            Toast.makeText(this, "Does Not Exist", Toast.LENGTH_SHORT).show();
    }
}