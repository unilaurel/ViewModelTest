package com.example.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.viewmodeltest.databinding.ActivityDataBindingBinding;
import com.example.viewmodeltest.viewmode.ViewModelWithDataBinding;

public class DataBindingActivity extends AppCompatActivity {
    ActivityDataBindingBinding binding;
    ViewModelWithDataBinding viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        viewModel = new ViewModelProvider(this).get(ViewModelWithDataBinding.class);

        viewModel.getNumber2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.text2.setText(String.valueOf(integer));
            }
        });

        binding.dbBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.minus();
            }
        });
    }
}