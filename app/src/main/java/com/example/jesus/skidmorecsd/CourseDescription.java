package com.example.jesus.skidmorecsd;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.StringSearch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CourseDescription extends AppCompatActivity {

    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_description);

        // Code related to Top Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor((Color.parseColor("#00514C")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Retrieve data from intent
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");

        // Code related to course description
        description = (TextView) findViewById(R.id.courseDescription);
        description.setText(getStringResource(id));
    }

    private String getStringResource(String identifier) {
        String packageName = getPackageName();
        int resourceId = getResources().getIdentifier(identifier, "string", packageName);
        return getString(resourceId);
    }
}
