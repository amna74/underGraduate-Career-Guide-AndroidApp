package com.example.undergradcareerguide.Engineering;

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
import com.example.undergradcareerguide.HomeScreen;
import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.demoTest.selectionQActivity;
import com.example.undergradcareerguide.medical.TestFragment;
import com.example.undergradcareerguide.medical.medicalActivity2;
import com.example.undergradcareerguide.medical.medicalHomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class EngineeringActivity2 extends AppCompatActivity {

    BottomNavigationView medicalnav;
    NavigationView navigationViewss;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering2);
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
        fragment= new EngineeringHomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();
        ft.replace(R.id.EngframeLayout,fragment);
        ft.commit();
//
        navigationViewss.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                switch (menuItem.getItemId())
                {
                    case R.id.Homes:
                        startActivity(new Intent(EngineeringActivity2.this, HomeScreen.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;


                    case R.id.Profile:
                        Toast.makeText(EngineeringActivity2.this, "Profile", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.share:
                        Toast.makeText(getApplicationContext(), "Shares", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    default:
                        Toast.makeText(EngineeringActivity2.this, "Nothing", Toast.LENGTH_LONG).show();


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
                        fragment= new EngineeringHomeFragment();
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
                ft.replace(R.id.EngframeLayout,fragment);
                ft.commit();
                return true;
            }
        });
    }
}