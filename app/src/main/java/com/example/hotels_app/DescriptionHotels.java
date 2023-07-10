package com.example.hotels_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionHotels extends AppCompatActivity {
    Button rent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_hotels);

        Intent intent = getIntent();
        String hotelName = intent.getStringExtra("hotelName");
        Log.d("Index", "hotelName: " + hotelName);

        AttrebuteHotels hotel = null;
        for (AttrebuteHotels h : AttrebuteHotels.hotels) {
            if (h.getName().equals(hotelName)) {
                hotel = h;
                break;
            }
        }

        if (hotel != null) {
            ImageView image = findViewById(R.id.coffee_image);
            image.setImageResource(hotel.getImageUrl());
            Button rent = findViewById(R.id.button);
            TextView txtName = findViewById(R.id.txtName);
            TextView txtDesc = findViewById(R.id.txtDesc);
            TextView txtprice = findViewById(R.id.txtprice);

            txtName.setText(hotel.getName());
            txtDesc.setText(hotel.getDescription());
            txtprice.setText(String.valueOf(hotel.getPrice()));

            rent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Hotel rented successfully!", Toast.LENGTH_SHORT).show();

                }
            });
        }


        else {
            Log.d("Index", "Hotel not found");
        }


    }
}