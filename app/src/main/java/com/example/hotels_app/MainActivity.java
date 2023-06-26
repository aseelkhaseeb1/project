package com.example.hotels_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout menu_addCar;
    private LinearLayout menu_feedback;
    private LinearLayout menu_home;
    private LinearLayout menu_aboutus;
    private LinearLayout menu_account;
    private RecyclerView recycler_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_layout = findViewById(R.id.recycler_layout);

        String[] captions = new String[HomeHotelCard.hotels.length];
        int[] ids = new int[HomeHotelCard.hotels.length];
        int[] price = new int[HomeHotelCard.hotels.length];

        for (int i = 0; i < captions.length; i++) {
            captions[i] = HomeHotelCard.hotels[i].getName();
            ids[i] = HomeHotelCard.hotels[i].getImageUrl();
            price[i] = (int) HomeHotelCard.hotels[i].getPrice();
        }
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
                    Intent intent = new Intent(MainActivity.this, DescriptionHotels.class);
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
          



    private void setupView() {

        menu_addCar = findViewById(R.id.menu_addCar);
        menu_feedback = findViewById(R.id.menu_feedback);
        menu_home = findViewById(R.id.menu_home);
        menu_aboutus = findViewById(R.id.menu_aboutus);
        menu_account = findViewById(R.id.menu_account);





    }


}





