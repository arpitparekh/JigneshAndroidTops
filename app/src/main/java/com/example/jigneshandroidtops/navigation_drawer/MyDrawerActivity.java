package com.example.jigneshandroidtops.navigation_drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityMyDrawerBinding;

public class MyDrawerActivity extends AppCompatActivity {

    private ActivityMyDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}