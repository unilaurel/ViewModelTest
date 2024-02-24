package com.example.basketballdemo.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.basketballdemo.R;

/**
 * @noinspection DataFlowIssue
 */
public class PreViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String shpName = getApplication().getResources().getString(R.string.shp_name);

    public SavedStateHandle getHandle() {
        return handle;
    }

    public PreViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            loads();
        }
    }

    private void loads() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);
        handle.set(key, x);
    }

    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue());
        editor.apply();
    }

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() + x);
//        save();
    }
}
