package com.counter.bottomNavBar.saved;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.counter.MainActivity;
import com.counter.R;
import com.counter.bottomNavBar.account.Account;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Saved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        // Get bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        // Set default view on app start
        bottomNavigationView.setSelectedItemId(R.id.saved);

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
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}
