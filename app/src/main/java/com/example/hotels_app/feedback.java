package com.example.hotels_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class feedback extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rating_exp_txt;
    EditText review_txt;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar = findViewById(R.id.ratingBar);
        rating_exp_txt = findViewById(R.id.rating_exp_txt);
        review_txt = findViewById(R.id.review_txt);
        submit_btn = findViewById(R.id.submit_btn);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rating_exp_txt.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        rating_exp_txt.setText("Very bad");
                        break;
                    case 2:
                        rating_exp_txt.setText("Need some improvement");
                        break;
                    case 3:
                        rating_exp_txt.setText("Good");
                        break;
                    case 4:
                        rating_exp_txt.setText("Great");
                        break;
                    case 5:
                        rating_exp_txt.setText("Awesome. I love it");
                        break;
                    default:
                        rating_exp_txt.setText("");
                }
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("carId", Context.MODE_PRIVATE);
                String carID =  sharedPreferences.getString("carId", "");

                SharedPreferences sharedPreferencesUser = getSharedPreferences("userId", Context.MODE_PRIVATE);
                String userID = sharedPreferencesUser.getString("userId", "");

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference feedbackRef = database.getReference("feedbacks").child(carID);


                String comment = review_txt.getText().toString();
                int rating = (int) ratingBar.getRating();

//                feedbackRef.push().setValue(userID, comment, rating);

                if (review_txt.getText().toString().isEmpty()) {
                    Toast.makeText(feedback.this, "Please fill in the feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    review_txt.setText("");
                    ratingBar.setRating(0);
                    Toast.makeText(feedback.this, "Thank you for sharing your feedback", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}