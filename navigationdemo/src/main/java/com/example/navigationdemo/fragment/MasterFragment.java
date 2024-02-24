package com.example.navigationdemo.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.navigationdemo.MyViewModel;
import com.example.navigationdemo.R;
import com.example.navigationdemo.databinding.FragmentMasterBinding;


public class MasterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentMasterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master, container, false);
        binding.setDatasss(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_masterFragment_to_secondFragment);
            }
        });

        binding.seekBar.setProgress(myViewModel.getNumber().getValue());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myViewModel.getNumber().setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return binding.getRoot();
    }
}