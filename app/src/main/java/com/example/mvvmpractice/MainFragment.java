package com.example.mvvmpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmpractice.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    FirstFragmentViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(this).get(FirstFragmentViewModel.class);

        binding.button.setOnClickListener(v -> viewModel.onPressed());

        viewModel.counter.observe(getViewLifecycleOwner(), counter -> {
            binding.textView.setText(counter.toString());
        });

        return binding.getRoot();
    }
}