package com.example.ciller.pm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Review extends AppCompatActivity {
    EditText editTextReview3;
    RatingBar ratingBarReview;
    SeekBar seekBarReview;
    ToggleButton toggleButtonReview;
    EditText editTextReview4;
    Button buttonSendFeedback;

    DatabaseReference databaseReviews1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        databaseReviews1 = FirebaseDatabase.getInstance().getReference("review");

        editTextReview3 = (EditText)findViewById(R.id.editTextReview3);
        ratingBarReview = (RatingBar)findViewById(R.id.ratingBarReview);
        seekBarReview = (SeekBar)findViewById(R.id.seekBarReview);
        toggleButtonReview = (ToggleButton)findViewById(R.id.toggleButtonReview);
        editTextReview4 = (EditText)findViewById(R.id.editTextReview4);

        buttonSendFeedback = (Button)findViewById(R.id.buttonSendFeedback);
        buttonSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addReview();
            }
        });
    }




    protected void addReview(){
        String email = editTextReview3.getText().toString().trim();
        int experience = ratingBarReview.getNumStars();
        int impact = seekBarReview.getProgress();
        String recom = toggleButtonReview.getText().toString().trim();
        //int hour = timePickerReview.getCurrentHour();
        String feedback = editTextReview4.getText().toString().trim();

        if(!TextUtils.isEmpty(email))
        {
           String id =  databaseReviews1.push().getKey();
           AllReviews r = new AllReviews(id, email, experience, impact, recom, feedback);
           databaseReviews1.child(id).setValue(r);
           Toast.makeText(this, "Review registered", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"Please enter your email", Toast.LENGTH_LONG).show();
        }




    }
}
