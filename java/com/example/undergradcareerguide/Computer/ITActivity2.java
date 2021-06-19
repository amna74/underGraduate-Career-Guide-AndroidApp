package com.example.undergradcareerguide.Computer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.undergradcareerguide.Account_Fragment;
import com.example.undergradcareerguide.Engineering.EngineeringActivity2;
import com.example.undergradcareerguide.Engineering.EngineeringHomeFragment;
import com.example.undergradcareerguide.HomeScreen;
import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.demoTest.selectionQActivity;
import com.example.undergradcareerguide.medical.TestFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class ITActivity2 extends AppCompatActivity {

    BottomNavigationView medicalnav;
    NavigationView navigationViewss;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itactivity2);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        medicalnav = findViewById(R.id.medicalNav);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationViewss=findViewById(R.id.drawernav);
        drawerLayout=findViewById(R.id.drawer);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Fragment fragment=null;
        fragment= new ITHomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();
        ft.replace(R.id.ComframeLayout,fragment);
        ft.commit();
//
        navigationViewss.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.Homes:
                        startActivity(new Intent(ITActivity2.this, HomeScreen.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Profile:
                        Toast.makeText(ITActivity2.this, "Profile", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.share:
                        Toast.makeText(getApplicationContext(), "Shares", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    default:
                        Toast.makeText(ITActivity2.this, "Nothing", Toast.LENGTH_LONG).show();


                }
                return true;
            }
        });


        medicalnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch(item.getItemId())
                {
                    case R.id.Home:
                        fragment= new ITHomeFragment();
                        break;

                    case R.id.Test:
                        fragment=new TestFragment();
                        break;
                    case R.id.account:
                        fragment= new Account_Fragment();
                        break;
                }


                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft =  fm.beginTransaction();
                ft.replace(R.id.ComframeLayout,fragment);
                ft.commit();
                return true;
            }
        });
    }
}