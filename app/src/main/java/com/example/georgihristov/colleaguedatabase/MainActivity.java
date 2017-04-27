package com.example.georgihristov.colleaguedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);


        Colleague colleague = new Colleague();
        colleague.setColleagueName("Georgy");
        colleague.setColleagueEmailAddress("hristovsotirovgeorgi@gmail.com");
        colleague.setColleagueSkypeName("georgy_11");
        colleague.setColleaguePhoneNumber("0883509049");
        colleague.setColleagueTitle("Level 1 Support");
        colleague.setColleaguePicture("https://developer.android.com/_static/images/android/touchicon-180.png");
        List<Colleague> colleagues = new ArrayList<>();
        ColleagueAdapter adapter = new ColleagueAdapter(colleagues);
        colleagues.add(colleague);



        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_colleague:
                Toast.makeText(this, "Here be dragons", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void addNewColleague(){
        Intent intent = new Intent(this,CreateColleague.class);
        startActivity(intent);
    }
}
