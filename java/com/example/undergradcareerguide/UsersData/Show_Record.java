package com.example.undergradcareerguide.UsersData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.undergradcareerguide.Database.DatabaseHelper;
import com.example.undergradcareerguide.Database.entries;
import com.example.undergradcareerguide.HomeScreen;
import com.example.undergradcareerguide.MainActivity;
import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.demoTest.ResultActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Show_Record extends AppCompatActivity {

    TextView textView, viewProfile, EditProfile;
    DatabaseHelper dbHandler;
    SQLiteDatabase db;
    Cursor cursor;
    ImageView userProfile;
    FirebaseAuth authData;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");
    String uid;
    FirebaseUser user;

    //ListAdapterPC listAdapter;
    ListView listView;
    ArrayList<String> Name;
    ArrayList<String> TestName;
    ArrayList<String> CorrectAns;
    ArrayList<String> WrongAns;
    ArrayList<String> Percentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        listView = findViewById(R.id.ListViewUsers);
        textView = findViewById(R.id.textVieweMail);
        userProfile=findViewById(R.id.profileImage);
        Name = new ArrayList<String>();
        TestName= new ArrayList<String>();
        CorrectAns = new ArrayList<String>();
        WrongAns = new ArrayList<String>();
        Percentage = new ArrayList<String>();
        user = authData.getInstance().getCurrentUser();
        uid=user.getUid();
        loadUserInformation();

        dbHandler = new DatabaseHelper(this);

        getAllUser();
        textView.setText(HomeScreen.userName);

        }





    public void getAllUser() {
        String[] projection = {
                entries.FeedEntry.COL1,
                entries.FeedEntry.COL2,
                entries.FeedEntry.COL3,
                entries.FeedEntry.COL4,
                entries.FeedEntry.COL5
        };

        Name.clear();
        TestName.clear();
        CorrectAns.clear();
        WrongAns.clear();
        Percentage.clear();

        String sortOrder =
                entries.FeedEntry.COL1 + " ASC";
//        String selection = entries.FeedEntry.COL1 + " = ?";
//        // selection argument
//        String[] selectionArgs = {Email};


        SQLiteDatabase db = dbHandler.getReadableDatabase();

        Cursor cursor = db.query(
                entries.FeedEntry.TableName, //Table to query
                projection,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        if (cursor.moveToFirst()) {

            do
            {
                Name.add(cursor.getString(cursor.getColumnIndex(entries.FeedEntry.COL1)));
                TestName.add(cursor.getString(cursor.getColumnIndex(entries.FeedEntry.COL2)));
                CorrectAns.add(cursor.getString(cursor.getColumnIndex(entries.FeedEntry.COL3)));
                WrongAns.add(cursor.getString(cursor.getColumnIndex(entries.FeedEntry.COL4)));
                Percentage.add(cursor.getString(cursor.getColumnIndex(entries.FeedEntry.COL5)));
            }
            while (cursor.moveToNext());
            // Adding user record to list
        }

        ListAdapterPC listAdapter = new ListAdapterPC(this, Name, TestName, CorrectAns, WrongAns, Percentage);

        listView.setAdapter(listAdapter);

        cursor.close();
        db.close();
    }

    private void loadUserInformation() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {


                if (snapshot.child(uid).hasChild("profilePic")) {
                    Glide.with(Show_Record.this).load(snapshot.child(uid).child("profilePic").getValue().toString()).into(userProfile);

                }


            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                Toast.makeText(Show_Record.this, "Network Issue ", Toast.LENGTH_SHORT).show();

            }
        });

    }
    }