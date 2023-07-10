package com.example.hotels_app;

public class AttrebuteHotels {
    private String name;
    private int imageUrl;
    private double price;
    private String description;


    public AttrebuteHotels(String name, double price , String description) {
        this.name = name;
        this.price = price;
        this.description = description;

    }





    public static final AttrebuteHotels[] hotels = {
            new AttrebuteHotels("Burj Al Arab" , R.drawable.h1, 1000,"Burj Al Arab: Iconic sail-shaped luxury hotel in Dubai, offering lavish suites and exceptional dining."),
            new AttrebuteHotels("The Ritz-Carlton",R.drawable.h2 , 800,"The Ritz-Carlton: Prestigious luxury hotel known for its elegance and impeccable service, providing exquisite accommodations and fine dining experiences."),
            new AttrebuteHotels("Hotel Savoy", R.drawable.h3, 900,"Hotel Savoy: A charming and elegant hotel known for its timeless sophistication, offering luxurious accommodations and exceptional hospitality."),
            new AttrebuteHotels("Hotel Plaza Athénée", R.drawable.h4, 1200,"Hotel Plaza Athénée: An iconic luxury hotel renowned for its opulent charm and unparalleled elegance, providing exquisite accommodations and world-class amenities."),
            new AttrebuteHotels("Grand Hyatt", R.drawable.h5, 950,"Grand Hyatt: A prestigious hotel offering a perfect blend of luxury and modernity, featuring elegant accommodations and exceptional amenities."),
            new AttrebuteHotels("The Peninsula", R.drawable.h6, 1100,"The Peninsula: A renowned luxury hotel synonymous with sophistication and impeccable service, offering exquisite accommodations and unparalleled hospitality."),
            new AttrebuteHotels("Four Seasons", R.drawable.h7, 1500,"Four Seasons: An iconic hotel brand known for its exceptional luxury and personalized service, providing lavish accommodations and unforgettable experiences."),
            new AttrebuteHotels("Hotel Arts", R.drawable.h8, 850,"Hotel Arts: A contemporary and stylish hotel offering modern luxury and artistic experiences, featuring elegant accommodations and exceptional amenities."),
            new AttrebuteHotels("Emirates Palace", R.drawable.h9, 1800,"Emirates Palace: An iconic palace-like hotel known for its majestic architecture and regal ambiance, offering opulent accommodations and unparalleled luxury."),
            new AttrebuteHotels("Mandarin Oriental", R.drawable.h10, 1000,"Mandarin Oriental: A luxurious and elegant hotel brand renowned for its impeccable service and refined accommodations, offering a harmonious blend of Eastern and Western influences.")
    };

    public AttrebuteHotels(String name, int imageUrl, double price, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public String getDescription () {
        return description;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }
}
