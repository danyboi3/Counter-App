package com.counter.bottomNavBar.account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.counter.MainActivity;
import com.counter.R;
import com.counter.bottomNavBar.saved.Saved;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Get bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        // Set default view on app start
        bottomNavigationView.setSelectedItemId(R.id.account);

        // Write business logic for bottom view listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.saved:
                        startActivity(new Intent(getApplicationContext(), Saved.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.account:
                        return true;
                }
                return false;
            }
        });

    }
}
