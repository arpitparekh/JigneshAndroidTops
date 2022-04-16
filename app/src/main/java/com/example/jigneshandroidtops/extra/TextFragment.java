package com.example.jigneshandroidtops.extra;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.FragmentTextBinding;


public class TextFragment extends Fragment {

    String data;

//    TextFragment(String data){
//
//        this.data = data;
//
//    }

    private FragmentTextBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTextBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.tv.setText(data);
    }
}