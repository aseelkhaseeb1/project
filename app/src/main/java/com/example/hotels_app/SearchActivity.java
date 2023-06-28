package com.example.hotels_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner hotelSpinner;
    private Button searchButton;

    private List<AttrebuteHotels> availableHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        hotelSpinner = findViewById(R.id.hotelSpinner);
        searchButton = findViewById(R.id.searchButton);

        // Get a list of random hotel names for the spinner
        List<String> hotelNames = getRandomHotelNames();

        // Create a list to hold the available hotels based on their names
        availableHotels = new ArrayList<>();
        for (AttrebuteHotels hotel : AttrebuteHotels.hotels) {
            if (hotelNames.contains(hotel.getName())) {
                availableHotels.add(hotel);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hotelNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hotelSpinner.setAdapter(adapter);
        hotelSpinner.setOnItemSelectedListener(this);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedHotelName = hotelSpinner.getSelectedItem().toString();
                boolean isHotelAvailable = isHotelAvailable(selectedHotelName);
                String message;
                if (isHotelAvailable) {
                    message = "The hotel " + selectedHotelName + " is available.";
                } else {
                    message = "The hotel " + selectedHotelName + " is not available.";
                }
                Toast.makeText(SearchActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> getRandomHotelNames() {
        // Get a random subset of hotel names
        List<String> allHotelNames = new ArrayList<>();
        for (AttrebuteHotels hotel : AttrebuteHotels.hotels) {
            allHotelNames.add(hotel.getName());
        }
        List<String> randomHotelNames = new ArrayList<>();
        Random random = new Random();
        int numOfHotels = random.nextInt(AttrebuteHotels.hotels.length) + 1;
        for (int i = 0; i < numOfHotels; i++) {
            int randomIndex = random.nextInt(allHotelNames.size());
            randomHotelNames.add(allHotelNames.get(randomIndex));
            allHotelNames.remove(randomIndex);
        }

        // Add additional hotel names
        List<String> additionalHotels = new ArrayList<>();
        additionalHotels.add("Raffles Hotel");
        additionalHotels.add("Shangri-La Hotel");
        additionalHotels.add("The Gritti Palace");
        additionalHotels.add("Hotel Majestic");
        additionalHotels.add("The Taj Mahal Hotel");
        additionalHotels.add("Atlantis The Palm");
        additionalHotels.add("Waldorf Astoria");
        additionalHotels.add("Al Rayya Hotel");
        additionalHotels.add("Marriott Hotel");
        additionalHotels.add("Coral Hotel");

        randomHotelNames.addAll(additionalHotels);

        return randomHotelNames;
    }

    private boolean isHotelAvailable(String hotelName) {
        for (AttrebuteHotels hotel : availableHotels) {
            if (hotel.getName().equals(hotelName)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}