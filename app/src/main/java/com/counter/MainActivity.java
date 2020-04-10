package com.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.counter.bottomNavBar.account.Account;
import com.counter.bottomNavBar.saved.Saved;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView counterDisplay;

    public void plusBtnClick(View view) {
        counter++;
        displayCounter();
    }

    public void minusBtnClick(View view) {
        if(counter != 0){
            counter--;
            displayCounter();
        }
    }

    public void displayCounter(){
        counterDisplay = findViewById(R.id.counterId);
        counterDisplay.setText(String.valueOf(counter));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterDisplay = findViewById(R.id.counterId);
        counterDisplay.setText(String.valueOf(counter));

        MobileAds.initialize(this, "ca-app-pub-8719777481074036~4481736843");
        AdView adView1 = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);

        // Get bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        // Set default view on app start
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Write business logic for bottom view listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.saved:
                        startActivity(new Intent(getApplicationContext(), Saved.class));
                        overridePendingTransition(0, 0);
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
