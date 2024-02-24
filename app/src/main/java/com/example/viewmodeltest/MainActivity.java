package com.example.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodeltest.viewmode.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    TextView textView;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        textView = findViewById(R.id.text_id);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        textView.setText(String.valueOf(myViewModel.num));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.num++;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.num = myViewModel.num + 2;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });
    }
}
