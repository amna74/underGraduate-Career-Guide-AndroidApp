package com.example.undergradcareerguide.demoTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.undergradcareerguide.Database.DatabaseHelper;
import com.example.undergradcareerguide.HomeScreen;
import com.example.undergradcareerguide.MainActivity;
import com.example.undergradcareerguide.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import static com.example.undergradcareerguide.HomeScreen.userName;
import static com.example.undergradcareerguide.MainActivity.userEmail;
import static com.example.undergradcareerguide.demoTest.NTest.numss;
import static com.example.undergradcareerguide.medical.TestFragment.TestType;


public class ResultActivity extends AppCompatActivity {

    TextView NameTextView,show,total,percent,right,wrong,testtype;
    Button done;
    DatabaseHelper databaseHelper;

    NTest abc = new NTest();
    float percentage = (float)(abc.marks*100)/(float)(numss);
    String Spercentage = String.valueOf(percentage);
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        databaseHelper = new DatabaseHelper(this);
        total= findViewById(R.id.totalmarks);
        percent= findViewById(R.id.percentage);
        right= findViewById(R.id.correctans);
        wrong= findViewById(R.id.wrongans);
        show= findViewById(R.id.markshow);
        NameTextView=findViewById(R.id.UserName);
        testtype= findViewById(R.id.TestType);

        done= findViewById(R.id.finalm4);
        String TestName=TestType;
        testtype.setText("TEST TYPE : "+TestName);
        TestType=null;

        String wrongs= String.valueOf(numss-abc.marks);

        total.setText("TOTAL MARKS = "+(String.valueOf(selectionQActivity.subtotal)));
        percent.setText("PERCENTAGE = "+(String.valueOf(percentage))+"%");
        right.setText("CORRECT ANSWER = "+(String.valueOf(abc.marks)));
        wrong.setText("WRONG ANSWERS = "+(String.valueOf(wrongs)));
        show.setText(String.valueOf("OBTAINED MARKS = "+(abc.marks*selectionQActivity.obmark)));
        done.setVisibility(View.VISIBLE);

        NameTextView.setText("Name : "+userName);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = databaseHelper.AddUserData(HomeScreen.userName,TestName, String.valueOf(abc.marks),wrongs,Spercentage);
                if (check==false){
                    Toast.makeText(getApplicationContext() , "Something Went Wrong" , Toast.LENGTH_LONG).show();
                }
                else if(check==true){
                    Toast.makeText(getApplicationContext() , "Data Successfully Added" , Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }


}