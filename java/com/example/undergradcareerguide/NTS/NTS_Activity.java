package com.example.undergradcareerguide.NTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.demoTest.ResultActivity;
import com.example.undergradcareerguide.demoTest.selectionQActivity;
import com.example.undergradcareerguide.medical.TestFragment;

import java.util.Random;

import static com.example.undergradcareerguide.NTS.DemoNTS.NTS2Ques;
import static com.example.undergradcareerguide.NTS.DemoNTS.NTSQues;

public class NTS_Activity extends AppCompatActivity {

    TextView ques,markss,remain, xyz;
    Button a,b,c,d,finish;

    static int count=0,marks=0;

    private int time = 90;
    private int a1=10;
    private int b1=5;
    int rem = 30;



    int countss=0,checkss,k;
    static int numss=30;
    Random rand = new Random();

    //working of an array
    static String NTSJava[][] = new String[numss][numss];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nts);

        if(TestFragment.chosenType==1)
        {
            while(countss<numss)
            {
                checkss=0;
                k=rand.nextInt(30);
                NTSJava[0][countss]= NTSQues[0][k];
                NTSJava[1][countss]= NTSQues[1][k];
                for(int i=0;i<numss;i++)
                {
                    if(NTSJava[0][countss]== NTSJava[0][i])
                    {
                        checkss++;
                    }
                }
                if(checkss==1) {
                    countss++;
                }
            }

        }
        else if(TestFragment.chosenType==2)
        {
            while(countss<numss)
            {
                checkss=0;
                k=rand.nextInt(30);
                NTSJava[0][countss]= NTS2Ques[0][k];
                NTSJava[1][countss]= NTS2Ques[1][k];
                for(int i=0;i<numss;i++)
                {
                    if(NTSJava[0][countss]== NTSJava[0][i])
                    {
                        checkss++;
                    }
                }
                if(checkss==1) {
                    countss++;
                }
            }
        }

        TestFragment.chosenType=0;




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

        markss.setText(String.valueOf(100) );
        ques.setText(NTSJava[0][count]);






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
                    Intent intent = new Intent(getApplicationContext(), NTS_ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NTSJava[1][count].equals("a"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTSJava[0][count]);
                }

                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(),  NTS_ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTSJava[1][count].equals("b"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTSJava[0][count]);
                }


                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(), NTS_ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTSJava[1][count].equals("c"))
                {
                    marks++;
                }
                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTSJava[0][count]);
                }


                if(count==(numss))
                {
                    Intent intent = new Intent(getApplicationContext(),  NTS_ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(NTSJava[1][count].equals("d"))
                {
                    marks++;
                }

                count++;
                if(count != numss)
                {
                    rem--;
                    remain.setText(String.valueOf(rem));
                    ques.setText(NTSJava[0][count]);
                }


                if(count==(numss))
                {

                    Intent intent = new Intent(getApplicationContext(), NTS_ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NTS_ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}