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

import com.example.navigationdemo.MyViewModel;
import com.example.navigationdemo.R;
import com.example.navigationdemo.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false);
        MyViewModel myViewModel;
        myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentSecondBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        binding.setDatasss(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_secondFragment_to_masterFragment);
            }
        });
        return binding.getRoot();
    }
}