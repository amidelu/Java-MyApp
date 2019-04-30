package com.amidelu.personaldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView socialCard, weatherCard, restaurantCard, carCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Defining ID with CardView
        socialCard = findViewById(R.id.socialCardViewId);
        weatherCard = findViewById(R.id.weatherCardViewId);
        restaurantCard = findViewById(R.id.restaurantCardViewId);
        carCard = findViewById(R.id.carCardViewId);

//        Implementing onclick on every card
        socialCard.setOnClickListener(this);
        weatherCard.setOnClickListener(this);
        restaurantCard.setOnClickListener(this);
        carCard.setOnClickListener(this);

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
}
