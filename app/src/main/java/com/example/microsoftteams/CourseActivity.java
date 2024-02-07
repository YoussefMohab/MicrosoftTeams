package com.example.microsoftteams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
    public void onLinkClick(View view) {
        Uri uri = Uri.parse("https://youtu.be/9CkpMm-n5iA");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void back(View view) {
        Intent k = new Intent(this, MainActivity.class );
        startActivity(k);
    }
}