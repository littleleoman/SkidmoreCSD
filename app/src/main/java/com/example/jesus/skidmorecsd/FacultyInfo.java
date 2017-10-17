package com.example.jesus.skidmorecsd;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FacultyInfo extends AppCompatActivity {

    Button sendEmail;
    String email;
    String title;
    String ID;

    TextView memberTitle;
    TextView memberInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_info);

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra("EMAIL");
        title = receivedIntent.getStringExtra("TITLE");
        ID = receivedIntent.getStringExtra("ID");

        memberTitle = (TextView) findViewById(R.id.memberTitle);
        memberTitle.setText(title);
        memberInfo = (TextView) findViewById(R.id.memberInformation);
        memberInfo.setText(getStringResource(ID));

        sendEmail = (Button) findViewById(R.id.sendEmail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                mailIntent.setType("plain/text");
                mailIntent.setData(Uri.parse(email));
                mailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
                startActivity(mailIntent);
            }
        });

        // Code related to Top Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor((Color.parseColor("#00514C")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Retrieve data from intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("EMAIL");
        String title = intent.getStringExtra("TITLE");
    }

    private String getStringResource(String identifier) {
        String packageName = getPackageName();
        int resourceId = getResources().getIdentifier(identifier, "string", packageName);
        return getString(resourceId);
    }
}
