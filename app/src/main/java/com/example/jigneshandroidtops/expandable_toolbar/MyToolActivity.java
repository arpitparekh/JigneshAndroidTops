package com.example.jigneshandroidtops.expandable_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityMyToolBinding;

public class MyToolActivity extends AppCompatActivity {

    private ActivityMyToolBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyToolBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
    }
}