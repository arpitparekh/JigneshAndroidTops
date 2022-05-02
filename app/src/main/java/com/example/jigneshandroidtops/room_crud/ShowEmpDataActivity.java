package com.example.jigneshandroidtops.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityShowEmpDataBinding;

public class ShowEmpDataActivity extends AppCompatActivity {

    private ActivityShowEmpDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowEmpDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();

        Emp e = (Emp) i.getSerializableExtra("obj");

        binding.tvName.setText(e.name);
        binding.tvAddress.setText(e.address);

    }
}