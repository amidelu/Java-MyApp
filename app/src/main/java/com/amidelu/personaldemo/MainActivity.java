package com.amidelu.personaldemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,BottomNavigationView.OnNavigationItemSelectedListener {
    CardView socialCard, weatherCard, restaurantCard, carCard;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Defining ID for CardView and Bottom Navigation
        socialCard = findViewById(R.id.socialCardViewId);
        weatherCard = findViewById(R.id.weatherCardViewId);
        restaurantCard = findViewById(R.id.restaurantCardViewId);
        carCard = findViewById(R.id.carCardViewId);

        bottomNavigationView = findViewById(R.id.navigationBottomId);

//        Implementing onclick on every card and bottom navigation
        socialCard.setOnClickListener(this);
        weatherCard.setOnClickListener(this);
        restaurantCard.setOnClickListener(this);
        carCard.setOnClickListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

//    On Click method implemented for every CardView
    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
        case R.id.socialCardViewId: intent = new Intent(this, SocialActivity.class);
        startActivity(intent);
        break;

        case R.id.weatherCardViewId: intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
        break;

        case R.id.restaurantCardViewId: intent = new Intent(this, RestaurantActivity.class);
        startActivity(intent);
        break;

        case R.id.carCardViewId: intent = new Intent(this, CarActivity.class);
        startActivity(intent);
        break;

        default:break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        switch (id) {

            case R.id.myProfileBottomId:
                startActivity(new Intent(this, MyProfile.class));
                break;

            case R.id.dashboardBottomId:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.settingsBottomId:
                Toast.makeText(MainActivity.this, "Settings Bottom Navigation clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }
}
