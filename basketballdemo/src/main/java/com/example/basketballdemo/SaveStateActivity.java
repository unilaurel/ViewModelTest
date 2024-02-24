package com.example.basketballdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.VideoView;

import com.example.basketballdemo.databinding.ActivitySaveStateBinding;
import com.example.basketballdemo.viewmodel.SaveStateViewModel;

public class SaveStateActivity extends AppCompatActivity {

    ActivitySaveStateBinding binding;
    SaveStateViewModel viewModel;
   public final static String KEY_NUM = "my_num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save_state);
        viewModel = new ViewModelProvider(this).get(SaveStateViewModel.class);

//        if (savedInstanceState != null) {
//            int anInt = savedInstanceState.getInt(KEY_NUM);
//            viewModel.getNum().setValue(anInt);
//        }

        binding.setSaveStatus(viewModel);
        binding.setLifecycleOwner(this);
    }

//   这个方法不行
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState,outPersistentState);
//        outState.putInt(KEY_NUM,viewModel.getNum().getValue());
//    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_NUM, viewModel.getNum().getValue());
//    }

}