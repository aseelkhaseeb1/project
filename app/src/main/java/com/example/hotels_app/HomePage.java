package com.example.hotels_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Type;


public class HomePage extends AppCompatActivity {

    private RecyclerView recycler_layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);






        recycler_layout = findViewById(R.id.recycler_layout);

        String[] captions = new String[HomeHotelCard.hotels.length];
        int[] ids = new int[HomeHotelCard.hotels.length];
        int[] price = new int[HomeHotelCard.hotels.length];

        for (int i = 0; i < captions.length; i++) {
            captions[i] = HomeHotelCard.hotels[i].getName();
            ids[i] = HomeHotelCard.hotels[i].getImageUrl();
            price[i] = (int) HomeHotelCard.hotels[i].getPrice();
        }


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String caption = gson.toJson(captions);

        editor.putString("123", caption);
        editor.commit();


        String str = prefs.getString("123", "");
        captions = gson.fromJson(str,String[].class);




        String image = gson.toJson(ids);

        editor.putString("12", image);
        editor.commit();


        String strId= prefs.getString("12", "");
        ids = gson.fromJson(strId, (Type) int[].class);





        String cost = gson.toJson(price);

        editor.putString("1", cost);
        editor.commit();


        String strCost= prefs.getString("1", "");
        price = gson.fromJson(strCost, int [].class);


        recycler_layout.setLayoutManager(new LinearLayoutManager(this));
        HomeHotelCardAdaptor adapter = new HomeHotelCardAdaptor(captions, ids, price);
        recycler_layout.setAdapter(adapter);

        RecyclerView.OnItemTouchListener recyclerTouchListener;

        recyclerTouchListener = new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && e.getAction() == MotionEvent.ACTION_UP) {
                    int position = rv.getChildAdapterPosition(childView);
                    Intent intent = new Intent(HomePage.this, DescriptionHotels.class);
                    intent.putExtra("hotelName", HomeHotelCard.hotels[position].getName());
                    intent.putExtra("hotelImageId", HomeHotelCard.hotels[position].getImageUrl());
                    intent.putExtra("hotelPrice", HomeHotelCard.hotels[position].getPrice());


                    startActivity(intent);
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
        };

        recycler_layout.addOnItemTouchListener(recyclerTouchListener);


    }
}