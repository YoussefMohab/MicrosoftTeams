package com.example.microsoftteams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {
    Button btn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Context context=this;
        btn =findViewById(R.id.btn);
        preferences=getSharedPreferences("MyPrefrences",MODE_PRIVATE);
        editor= preferences.edit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Intent intent=new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });



        ImageView imageView = findViewById(R.id.profile);
        Glide.with(this)
                .load(R.drawable.teamsprofile)
                .circleCrop()
                .into(imageView);
        ImageView c = findViewById(R.id.c);
        ImageView s = findViewById(R.id.s);
        ImageView o = findViewById(R.id.o);

        ImageButton x = findViewById(R.id.close);
        x.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(i);
            }

        });



    }

    public void chat(View view) {

        Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
    }

    public void sound(View view) {
        Toast.makeText(this, "Activity", Toast.LENGTH_SHORT).show();

    }

    public void organization(View view) {
        Toast.makeText(this, "Organization", Toast.LENGTH_SHORT).show();

    }


    public void logout(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
