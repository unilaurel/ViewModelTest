package com.example.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class LifecycleActivity extends AppCompatActivity {
private long elapedTime;
    MyChronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        chronometer = findViewById(R.id.meter);
        chronometer.setBase(SystemClock.elapsedRealtime());
        getLifecycle().addObserver(chronometer);
//        chronometer.start();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        elapedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
//        chronometer.stop();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        chronometer.setBase(SystemClock.elapsedRealtime()-elapedTime);
//        chronometer.start();
//    }
}