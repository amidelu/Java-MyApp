package com.amidelu.personaldemo;

// This is Navigation drawer java class. Navigation drawer depends on 2 layout resource file (navigation drawer & navigation header) and 1 menu file (navigation menu)

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

// Implementing navigation selected method
public class MyProfile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Defining objects
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To set navigation drawer in My Profile page, need to change setContentView layout from activity_my_profile to navigation_drawer
        setContentView(R.layout.navigation_drawer);

        // Id referencing to the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Id referencing to above objects
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // Setting implemented method to this activity
        navigationView.setNavigationItemSelectedListener(this);

        // Navigation drawer open and close toggle code goes here
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();
    }

    // Implementing override methods for on back button press navigation drawer close and then go back to previous activity
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
        super.onBackPressed();
        }
    }

    // Navigation drawer items conditions apply code goes here
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        switch (id) {
            case R.id.dashboardId:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.favouriteId:

                break;

            case R.id.socialId:

                break;

            case R.id.shareId:

                break;

            case R.id.exitId:

                break;

        }

        return true;
    }
}
