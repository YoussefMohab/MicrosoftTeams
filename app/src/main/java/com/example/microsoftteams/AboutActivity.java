package com.example.microsoftteams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    RelativeLayout terms, privacy, third, connected ;
    Switch developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent i= getIntent();

        terms = findViewById(R.id.Terms);
        privacy = findViewById(R.id.Privacy);
        third = findViewById(R.id.Third);
        connected = findViewById(R.id.connected);
        developer = findViewById(R.id.Developer);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.microsoft.com/en-us/legal/terms-of-use");
                Intent terms = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(terms);
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://privacy.microsoft.com/en-us/privacystatement");
                Intent privacy = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(privacy);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.microsoft.com/en-us/legal/third-party-notices");
                Intent third = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(third);
            }
        });
        connected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://learn.microsoft.com/en-us/microsoftteams/teams-privacy-oce-overview");
                Intent connected = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(connected);
            }
        });
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (developer.isChecked()) {
                    Toast.makeText(AboutActivity.this, "Developer mode on", Toast.LENGTH_SHORT).show();
                } else {
                    // Switch is OFF
                }
            }
        });


        ImageButton x = findViewById(R.id.close);
        x.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(i);
            }

        });
    }
}







