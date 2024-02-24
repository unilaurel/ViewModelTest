package com.example.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.viewmodeltest.viewmode.ViewModelWithLiveData;

public class LiveDataActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;
    ImageButton like, dislike;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        textView = findViewById(R.id.lv_text);
        like = findViewById(R.id.lv_btn1);
        dislike = findViewById(R.id.lv_btn2);


        viewModelWithLiveData = new ViewModelProvider(this).get(ViewModelWithLiveData.class);
        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(1);
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(-1);
            }
        });
    }
}