package com.example.undergradcareerguide;

import android.content.DialogInterface;
import android.content.Intent;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;
import com.example.undergradcareerguide.Computer.ITActivity2;
import com.example.undergradcareerguide.Database.DatabaseHelper;
import com.example.undergradcareerguide.Engineering.EngineeringActivity2;
import com.example.undergradcareerguide.NonEng.NonEngActivity2;
import com.example.undergradcareerguide.UsersData.Show_Record;
import com.example.undergradcareerguide.demoTest.ResultActivity;
import com.example.undergradcareerguide.demoTest.selectionQActivity;
import com.example.undergradcareerguide.medical.medicalActivity2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import static com.example.undergradcareerguide.MainActivity.loginCheck;


public class HomeScreen extends AppCompatActivity {

    Button medical,eng,tech,nonEng;


    FirebaseAuth authData;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");
    public static String userName=null;
    public static String userEmail=null;
    public static String userGender=null;

    String uid;
    FirebaseUser user;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        user = authData.getInstance().getCurrentUser();
        uid=user.getUid();
        loadUserInformation();


        databaseHelper = new DatabaseHelper(this);
        medical=findViewById(R.id.btn_medical);
        eng=findViewById(R.id.eng);
        tech=findViewById(R.id.tech);
        nonEng=findViewById(R.id.nonEng);

        loginCheck=2;



        authData = FirebaseAuth.getInstance();


        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent med = new Intent(getApplicationContext(), medicalActivity2.class);
                startActivity(med);
            }
        });


        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(getApplicationContext(), EngineeringActivity2.class);
                startActivity(test);
            }
        });


        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent test = new Intent(getApplicationContext(), ITActivity2.class);
                startActivity(test);
            }
        });

        nonEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(getApplicationContext(), NonEngActivity2.class);
                startActivity(test);

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logoutmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.Record:
                    startActivity(new Intent(getApplicationContext(), Show_Record.class));

                    Toast.makeText(this, "Progress Report", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.logout:
                    alert();
                    break;

                default:
                    break;

            }
        return true;
    }

    private void loadUserInformation()
    {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                if(snapshot.child(uid).hasChild("userName"))
                {
                    userName= snapshot.child(uid).child("userName").getValue().toString();

                }

                else if(snapshot.child(uid).hasChild("firstName"))
                {

                    userName= snapshot.child(uid).child("firstName").getValue().toString();
                }



                if(snapshot.child(uid).hasChild("gender"))
                {
                    userGender= snapshot.child(uid).child("gender").getValue().toString();
                }
                else if (userName.equals("Afaq Toufeeq"))
                {
                    userGender="Male";
                }


                if(snapshot.child(uid).hasChild("email"))
                {
                    userEmail= snapshot.child(uid).child("email").getValue().toString();
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                Toast.makeText(HomeScreen.this, "Network Issue ", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void alert()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(HomeScreen.this)
                .setTitle("Confirm Logout")
                .setMessage("Do you really want to logout ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(HomeScreen.this, "Log Out ", Toast.LENGTH_SHORT).show();
                        authData.signOut();
                        finish();
                        Intent logout = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(logout);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }


}