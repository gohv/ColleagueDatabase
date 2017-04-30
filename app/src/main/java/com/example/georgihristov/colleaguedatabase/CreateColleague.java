package com.example.georgihristov.colleaguedatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateColleague extends AppCompatActivity{

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("colleague");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcolleague_activity);


        Colleague colleague = new Colleague();
        colleague.setColleagueName("Georgy");
        colleague.setColleagueEmailAddress("hristovsotirovgeorgi@gmail.com");
        colleague.setColleagueSkypeName("georgy_11");
        colleague.setColleaguePhoneNumber("0883509049");
        colleague.setColleagueTitle("Level 1 Support");
        colleague.setColleaguePicture("https://developer.android.com/_static/images/android/touchicon-180.png");

        reference.push().setValue(colleague);
    }
}
