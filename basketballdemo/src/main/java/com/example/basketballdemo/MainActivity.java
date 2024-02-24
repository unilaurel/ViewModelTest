package com.example.basketballdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.basketballdemo.databinding.ActivityMainBinding;
import com.example.basketballdemo.viewmodel.BasViewModel;

public class MainActivity extends AppCompatActivity {

    BasViewModel viewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(BasViewModel.class);

        binding.setDatas(viewModel);
        binding.setLifecycleOwner(this);

    }
}