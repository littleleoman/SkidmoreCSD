package com.example.jesus.skidmorecsd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TableRow;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TableRow tr0;
    TableRow tr1;
    TableRow tr2;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Code related to Top Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor((Color.parseColor("#00514C")));
        setSupportActionBar(toolbar);

        // Code related to the Left Side Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Code related to Skidmore Logo
        logo = (ImageView) findViewById(R.id.skidLogo);
        TranslateAnimation moveDown = new TranslateAnimation(0,0,0, 200);
        moveDown.setDuration(1500);
        moveDown.setFillAfter(true);
        logo.startAnimation(moveDown);

        // Code related to Table Layout
        tr0 = (TableRow) findViewById(R.id.tableRow0);
        tr0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutCS = new Intent(Home.this, AboutCS.class);
                startActivity(aboutCS);
            }
        });
        tr1 = (TableRow) findViewById(R.id.tableRow1);
        tr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tr2.getVisibility() == View.GONE) {
                    TranslateAnimation moveUp = new TranslateAnimation(0, 0, 0, -150);
                    moveUp.setDuration(500);
                    moveUp.setFillAfter(true);
                    logo.startAnimation(moveUp);

                    tr1.setBackgroundColor(ContextCompat.getColor(Home.this, R.color.secondaryGreen));
                    tr2.setVisibility(View.VISIBLE);
                } else {
                    TranslateAnimation moveDown = new TranslateAnimation(0,0,0, 150);
                    moveDown.setDuration(500);
                    moveDown.setFillAfter(true);
                    logo.startAnimation(moveDown);

                    tr1.setBackgroundColor(ContextCompat.getColor(Home.this, R.color.primaryGreen));
                    tr2.setVisibility(View.GONE);
                }
            }
        });
        tr2 = (TableRow) findViewById(R.id.tableRow2);
        tr2.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_faculty) {
            // Transition to faculty info
            Intent facultyIntent = new Intent(this, FacultyList.class);
            startActivity(facultyIntent);
        } else if (id == R.id.nav_courses) {
            // Transition to list of courses
            Intent coursesIntent = new Intent(this, CourseList.class);
            startActivity(coursesIntent);
        } else if (id == R.id.nav_honors) {
            // Transition to honors info
            Intent honorsIntent = new Intent(this, Honors.class);
            startActivity(honorsIntent);
        } else if (id == R.id.nav_major) {
            // Transition to major info
            Intent majorIntent = new Intent(this, MajorRequirements.class);
            startActivity(majorIntent);
        } else if (id == R.id.nav_minor) {
            // Transition to minor info
            Intent minorIntent = new Intent(this, MinorRequirements.class);
            startActivity(minorIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
