package com.example.microsoftteams;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    Context context;
    List<teams> product;

    public MyAdapter(Context context, List<teams> product) {
        this.context = context;
        this.product = product;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.teams, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.CourseName.setText(product.get(position).getCourseName());
        holder.image.setImageResource(product.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return product.size();
    }

}

