package com.example.microsoftteams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyReceiver objReciver = new MyReceiver();
        IntentFilter IF = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        IntentFilter IFF = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        IntentFilter IFFF = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

            registerReceiver(objReciver, IF);
            registerReceiver(objReciver, IFF);
            registerReceiver(objReciver, IFFF);


        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                .setMinimumLatency(10000) // Run every 10
                // seconds (adjust the interval as needed)
                .build();
        jobScheduler.schedule(jobInfo);

        RecyclerView teams = findViewById(R.id.recyclerview1);

        List<teams> team = new ArrayList<teams>();
        team.add(new teams(R.drawable.cslogo ,"Mobile Application"));
        team.add(new teams(R.drawable.cslogo2 , "Cloud Computing"));
        team.add(new teams(R.drawable.cslogo3 , "Numerical Computation"));
        team.add(new teams(R.drawable.cslogo4 , "AI for Games"));

        teams.setLayoutManager(new LinearLayoutManager(this));
        teams.setAdapter(new MyAdapter(getApplicationContext(), team));

        ImageButton info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), AboutActivity.class );
                    startActivity(i);
                }

        });


        ImageView profile = findViewById(R.id.profile);

        Glide.with(this)
                .load(R.drawable.teamsprofile)
                .circleCrop()
                .into(profile);


        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), ProfileActivity.class );
                startActivity(j);
            }

        });

    }

    public void course(View view) {
        Intent k = new Intent(this, CourseActivity.class );
        startActivity(k);
    }
}