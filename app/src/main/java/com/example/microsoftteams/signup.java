package com.example.microsoftteams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText name;
    EditText pass;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void sign_up(View view) {
        preferences = getSharedPreferences("MyPrefrences", MODE_PRIVATE);
        editor = preferences.edit();
        name=findViewById(R.id.edittext_email);
        pass=findViewById(R.id.edittext_email);
        String my_name = name.getText().toString();
        String my_pass = pass.getText().toString();
        editor.putString("saved_name", my_name);
        editor.putString("saved_password", my_pass);
        editor.commit();
        String name=preferences.getString("saved_name","");
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}