package com.example.microsoftteams;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;



public class MyJobService extends JobService {

    private static final String CHANNEL_ID = "notification_channel";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public boolean onStartJob(JobParameters params) {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName)
                .setMinimumLatency(50000) // Run every 50 seconds (adjust the interval as needed)
                .build();
        jobScheduler.schedule(jobInfo);
        showNotification();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private void showNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Notification Channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel description");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_job_running)
                .setContentTitle("Teams")
                .setContentText("Schedule is running")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        Notification notification = builder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }}




