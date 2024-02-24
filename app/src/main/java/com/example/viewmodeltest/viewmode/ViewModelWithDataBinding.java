package com.example.viewmodeltest.viewmode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithDataBinding extends ViewModel {
    private MutableLiveData<Integer> number1;
    private MutableLiveData<Integer> number2;

    public MutableLiveData<Integer> getNumber1() {
        if (number1 ==null){
            number1 = new MutableLiveData<>();
            number1.setValue(0);
        }
        return number1;
    }

    public MutableLiveData<Integer> getNumber2() {
        if (number2 ==null){
            number2 = new MutableLiveData<>();
            number2.setValue(0);
        }
        return number2;
    }

    public void add(){
        number1.setValue(number1.getValue()+1);
    }

    public void minus(){
        number2.setValue(number2.getValue()-10);
    }
}
