package com.example.jigneshandroidtops.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityMyShapeBinding;

public class MyShape extends AppCompatActivity {

    private ActivityMyShapeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyShapeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}