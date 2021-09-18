package com.example.usercollegeapp.Developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.usercollegeapp.R;

public class DeveloperDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);       //It will set a closing Arrow on the top of Ebook Activity:-
        getSupportActionBar().setTitle("Developer");                //it will set the title on the top of the activity:-

//        getSupportActionBar().hide();   //for hinding ActionBar
    }
}