package com.example.hotels_app;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotels_app.R;
import com.example.hotels_app.registration;


public class LogInActivity extends AppCompatActivity {
    private Button login;
    private Button signup;
    private EditText login_email;
    private EditText login_pass;

    private SharedPreferences prefs;//for read
    private SharedPreferences.Editor editor;//for write
    private String email;
    private String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        extracted();
        setUpPrefs();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main.class);
                startActivity(i);
            }
        });



    }

    private void setUpPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void extracted() {
        login = findViewById(R.id.login);
        login_email = findViewById(R.id.login_email);
        login_pass = findViewById(R.id.login_pass);
        signup = findViewById(R.id.login_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, registration.class);
                startActivity(intent);

            }
        });
    }



    private void saveEmail() {
        editor.putString("email", email);
        editor.putString("pass", pass);
        editor.commit();
    }

}