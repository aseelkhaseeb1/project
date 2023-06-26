package com.example.hotels_app;

public class HomeHotelCard {
    private String name;
    private int imageUrl;
    private double price;

    public static final HomeHotelCard[] hotels = {
            new HomeHotelCard("Burj Al Arab" , R.drawable.h1, 1000),
            new HomeHotelCard("The Ritz-Carlton",R.drawable.h2 , 800),
            new HomeHotelCard("Hotel Savoy", R.drawable.h3, 900),
            new HomeHotelCard("Hotel Plaza Athénée", R.drawable.h4, 1200),
            new HomeHotelCard("Grand Hyatt", R.drawable.h5, 950),
            new HomeHotelCard("The Peninsula", R.drawable.h6, 1100),
            new HomeHotelCard("Four Seasons", R.drawable.h7, 1500),
            new HomeHotelCard("Hotel Arts", R.drawable.h8, 850),
            new HomeHotelCard("Emirates Palace", R.drawable.h9, 1800),
            new HomeHotelCard("Mandarin Oriental", R.drawable.h10, 1000)
    };

    public HomeHotelCard(String name, int imageUrl, double price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }
}
