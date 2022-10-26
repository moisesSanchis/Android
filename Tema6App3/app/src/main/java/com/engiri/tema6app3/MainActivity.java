package com.engiri.tema6app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.engiri.tema6app3.fragments.DashboardFragment;
import com.engiri.tema6app3.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.menu_navigation);
        navigationView.setOnItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment f = null;

        switch (item.getItemId()){
            case R.id.navigation_home:
                f = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                f= new DashboardFragment();
                break;
        }

        if(f!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedor, f).commit();
        }

        return true;
    }
}