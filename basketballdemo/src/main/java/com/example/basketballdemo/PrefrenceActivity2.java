package com.example.basketballdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;

import com.example.basketballdemo.databinding.ActivityPrefrence2Binding;
import com.example.basketballdemo.viewmodel.PreViewModel;

public class PrefrenceActivity2 extends AppCompatActivity {

    PreViewModel viewModel;
    ActivityPrefrence2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_prefrence2);
        viewModel = new ViewModelProvider(this).get(PreViewModel.class);

        binding.setPre(viewModel);
        binding.setLifecycleOwner(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.save();
    }
}