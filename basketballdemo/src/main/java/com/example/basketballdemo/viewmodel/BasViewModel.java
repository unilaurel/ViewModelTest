package com.example.basketballdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BasViewModel extends ViewModel {
    private MutableLiveData<Integer> num1;
    private MutableLiveData<Integer> num2;
    private int aBack,bBack;

    public MutableLiveData<Integer> getNum1() {
        if (num1 == null) {
            num1 = new MutableLiveData<>();
            num1.setValue(0);
        }
        return num1;
    }

    public MutableLiveData<Integer> getNum2() {
        if (num2 == null) {
            num2 = new MutableLiveData<>();
            num2.setValue(0);
        }
        return num2;
    }

//    public void add1A(){
//        num1.setValue(num1.getValue()+1);
//    }
//
//    public void add2A(){
//        num1.setValue(num1.getValue()+2);
//    }
//
//    public void add3A(){
//        num1.setValue(num1.getValue()+3);
//    }

//    public void add1B(){
//        num2.setValue(num2.getValue()+1);
//    }
//
//    public void add2B(){
//        num2.setValue(num2.getValue()+2);
//    }
//
//    public void add3B(){
//        num2.setValue(num2.getValue()+3);
//    }

    public void addA(int p) {
        aBack = num1.getValue();
        bBack = num2.getValue();
        num1.setValue(num1.getValue() + p);
    }

    public void addB(int p) {
        aBack = num1.getValue();
        bBack = num2.getValue();
        num2.setValue(num2.getValue() + p);
    }

    public void reset() {
        num1.setValue(0);
        num2.setValue(0);
    }

    public void refresh(){
        num1.setValue(aBack);
        num2.setValue(bBack);
    }
}
