package com.example.microsoftteams;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    EditText Name, pass;
    Button signup;
    Button btn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Button changelang;
    private String[] listItems;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup =findViewById(R.id.signbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,signup.class);
                startActivity(intent);
            }
        });



        changelang = findViewById(R.id.changelang);
        changelang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show alert diag to display list of languages,one can be selected
                showChangeLanguageDialog();
            }
        });
        loadLocal();
        btn = findViewById(R.id.button_signin);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    preferences = getSharedPreferences("MyPrefrences", MODE_PRIVATE);
//                    editor = preferences.edit();
//                    //Context context = this;
//                    if (preferences.contains("saved_name")) {
//                        Name = findViewById(R.id.edittext_email);
//                        pass = findViewById(R.id.edittext_password);
//                        String my_name = Name.getText().toString();
//                        String my_pass = pass.getText().toString();
//                        String savedname=preferences.getString("saved_name","");
//                        String savedpass=preferences.getString("saved_password","");
//                        if(my_name.isEmpty()){
//                            Toast.makeText(context,"NOT FOUND",Toast.LENGTH_LONG).show();
//                        }else if(my_name.equals(savedname)&& my_pass.equals(savedpass)){
//                            Intent intent = new Intent(context, MainActivity.class);
//                            startActivity(intent);
//                        }
//
//                    } else {
//                        Toast.makeText(context,"NOT FOUND",Toast.LENGTH_LONG).show();}
//                }
//            });


//            Name = findViewById(R.id.edittext_email);
//            pass = findViewById(R.id.edittext_password);
//            btn = findViewById(R.id.button_signin);
//            btn.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    String my_name = Name.getText().toString();
//                    String my_pass = pass.getText().toString();
//                    editor.putString("saved_name", my_name);
//                    editor.putString("saved_password", my_pass);
//                    editor.commit();
//                    Intent intent = new Intent(context, MainActivity.class);
//                    startActivity(intent);
//                }
//            });

    }

    private void showChangeLanguageDialog() {
        // array of languages to display in alert dialog
        listItems = new String[]{"French", "عربي", "Italiano", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        mBuilder.setTitle("Choose your language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("fr");
                    recreate();
                } else if (i == 1) {
                    setLocale("ar");
                    recreate();
                } else if (i == 2) {
                    setLocale("it");
                    recreate();
                } else if(i==3){
                    setLocale("en");   //default
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        // Save the language preference to shared preferences
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("My_lang", lang);
        editor.apply();
    }

    // load language saved in shared preference
    protected void loadLocal() {
        // Retrieve the user's language preference from shared preferences
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_lang", "default");
        // Set the language of the application
        setLocale(language);
    }

    public void sign_in(View view) {
        preferences = getSharedPreferences("MyPrefrences", MODE_PRIVATE);
        editor = preferences.edit();
        //Context context = this;
        if (preferences.contains("saved_name")) {
            Name = findViewById(R.id.edittext_email);
            pass = findViewById(R.id.edittext_password);
            String my_name = Name.getText().toString();
//            String my_pass = pass.getText().toString();
            String savedname=preferences.getString("saved_name","");
//            String savedpass=preferences.getString("saved_password","");
//            Toast.makeText(this,savedname,Toast.LENGTH_LONG).show();
            if(my_name.isEmpty()){
                Toast.makeText(context,"EMPTY",Toast.LENGTH_LONG).show();
            }else if(my_name.equals(savedname)){
                //Toast.makeText(context,"NOT FOUND",Toast.LENGTH_LONG).show();
                Toast.makeText(this,savedname,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            } else if (!my_name.equals(savedname)) {
                Toast.makeText(this,"NOT FOUND",Toast.LENGTH_LONG).show();

            }

        } else {
            Toast.makeText(context,"NOT REGESTIED",Toast.LENGTH_LONG).show();}

    }
}
