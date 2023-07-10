package com.example.hotels_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Main extends AppCompatActivity {


    private LinearLayout menu_addCar;
    private LinearLayout menu_feedback;
    private LinearLayout menu_home;
    private LinearLayout menu_aboutus;
    private LinearLayout menu_account;
    private RecyclerView recycler_layout;
    private LinearLayout menu_search;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recycler_layout = findViewById(R.id.recycler_layout);

        setupView();


    }
          



    @SuppressLint("WrongViewCast")
    private void setupView() {

        menu_addCar = findViewById(R.id.menu_addCar);
        menu_feedback = findViewById(R.id.menu_feedback);
        menu_home = findViewById(R.id.menu_home);
        menu_aboutus = findViewById(R.id.menu_aboutus);
        menu_account = findViewById(R.id.menu_account);
        menu_search=findViewById(R.id.menu_search);


        menu_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(i);
            }
        });



        menu_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });




        menu_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(i);
            }
        });



        menu_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomePage.class);
                startActivity(i);
            }
        });



        menu_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), feedback.class);
                startActivity(i);
            }
        });




    }


}





