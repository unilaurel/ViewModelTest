package com.example.roomdemo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

private WordRepository repository;
    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);

    }

    void insertWords(Word...words){
        repository.insertWords(words);
    }
    void updateWords(Word...words){
        repository.updateWords(words);
    }
    void deleteWords(){
        repository.deleteWords();
    }


    public LiveData<List<Word>> getAllWordsLive() {
        return repository.getAllWordsLive();
    }
}
