package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnUpdate, btnClear;
    TextView textView;
    WordViewModel wordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btn_insert);
        btnUpdate = findViewById(R.id.btn_update);
        btnClear = findViewById(R.id.btn_clear);
        textView = findViewById(R.id.textView);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word);
                }
                textView.setText(text.toString());
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("hello", "我是fafa");
                Word word2 = new Word("nihao", "我是menglan");
//                wordDao.insertWords(word1,word2);
                wordViewModel.insertWords(word1, word2);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("sheiya", "我是guolai");
                word.setId(38);
//                wordDao.updateWords(word);
                wordViewModel.updateWords(word);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                wordDao.deleteAllWords();
                wordViewModel.deleteWords();
            }
        });


    }


}