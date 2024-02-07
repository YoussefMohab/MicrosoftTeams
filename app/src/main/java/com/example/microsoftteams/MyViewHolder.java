package com.example.microsoftteams;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView CourseName;
    Button button;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image1);
        CourseName = itemView.findViewById(R.id.text1);
        button = itemView.findViewById(R.id.generalbtn);
    }
}

