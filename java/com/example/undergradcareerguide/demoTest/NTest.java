package com.example.undergradcareerguide.demoTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;

import java.util.Random;

import static com.example.undergradcareerguide.demoTest.DemoJavaTeset.javaQ;


public class NTest extends AppCompatActivity {

    TextView ques,markss,remain, xyz;
    Button a,b,c,d,finish;

    static int count=0,marks=0;

    private int time = selectionQActivity.Objtime;
    private int a1=10;
    private int b1=5;

   selectionQActivity total = new selectionQActivity();
    int rem = total.objnumm;

    int countss=0,checkss,k;
    static int numss=selectionQActivity.objnumm;
    Random rand = new Random();
    //working of an array
    static String NTJava[][] = new String[numss][numss];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntest);
        while(countss<numss)
        {
            checkss=0;
            k=rand.nextInt(30);
            NTJava[0][countss]= javaQ[0][k];
            NTJava[1][countss]= javaQ[1][k];
            for(int i=0;i<numss;i++)
            {
                if(NTJava[0][countss]== NTJava[0][i])
                {
                    checkss++;
                }
            }
            if(checkss==1) {
                countss++;
            }
        }




        remain= findViewById(R.id.remaining);

        markss = findViewById(R.id.totalmarks);
        ques = findViewById(R.id.question);
        a= findViewById(R.id.aa);
        b= findViewById(R.id.bb);
        c= findViewById(R.id.cc);
        d= findViewById(R.id.dd);
        finish = findViewById(R.id.finishquiz);
        xyz = findViewById(R.id.xyz);

        remain.setText(String.valueOf(rem));

        markss.setText(String.valueOf(total.subtotal) );
        ques.setText(NTJava[0][count]);






            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {

                    if (time > 0 ){
                        a1--;
                        if (a1==0){
                            if (time-1 > 9)
                                xyz.setText((time-1)+":"+b1+a1);
                            else
                                xyz.setText("0"+(time-1)+":"+b1+a1);
                            b1--;
                            a1=10;
                            if (b1==-1){
                                time--;
                                b1=5;
                            }
                        }
                        else
                            xyz.setText("0"+(time-1)+":"+b1+a1);
                        handler.postDelayed(this , 1000);
                    }
                    else if (count==(numss)){

                    }
                    else{
                        xyz.setText("00:00");
                        Toast.makeText(getApplicationContext(), "Time Finished", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NTJava[1][count].equals("a"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTJava[0][count]);
                }

                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTJava[1][count].equals("b"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTJava[0][count]);
                }


                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTJava[1][count].equals("c"))
                {
                    marks++;
                }
                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTJava[0][count]);
                }


                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTJava[1][count].equals("d"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTJava[0][count]);
                }


                if(count==(numss))
                {

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}