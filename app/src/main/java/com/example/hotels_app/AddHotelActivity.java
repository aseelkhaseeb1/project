package com.example.hotels_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class AddHotelActivity extends AppCompatActivity {
    public ArrayList<AttrebuteHotels> hotels;
    private EditText nameEditText, priceEditText, descriptionEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);

        // Initialize the hotels list
        hotels = new ArrayList<>();

        // Find views by their respective IDs
        nameEditText = findViewById(R.id.nameEditText);
        priceEditText = findViewById(R.id.priceEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String name = nameEditText.getText().toString();
                double price = Double.parseDouble(priceEditText.getText().toString());
                String description = descriptionEditText.getText().toString();

                // Create a new hotel object
                AttrebuteHotels hotel = new AttrebuteHotels(name, price, description);

                // Add the hotel to the list
                hotels.add(hotel);
                System.out.println("FFF");

                System.out.println(hotels);
                Toast.makeText(getApplicationContext(), "Hotel added successfully!", Toast.LENGTH_SHORT).show();

                // Clear the input fields
                nameEditText.getText().clear();
                priceEditText.getText().clear();
                descriptionEditText.getText().clear();

            }
        });
    }
}
