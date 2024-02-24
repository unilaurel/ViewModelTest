package com.example.basketballdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.basketballdemo.SaveStateActivity;

public class SaveStateViewModel extends ViewModel {
    //    private MutableLiveData<Integer> num;
    private SavedStateHandle handle;

    public SaveStateViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNum() {
        if (!handle.contains(SaveStateActivity.KEY_NUM)) {
            handle.set(SaveStateActivity.KEY_NUM, 0);
        }
        return handle.getLiveData(SaveStateActivity.KEY_NUM);
    }

    public void add() {
        getNum().setValue(getNum().getValue() + 1);
    }
}
