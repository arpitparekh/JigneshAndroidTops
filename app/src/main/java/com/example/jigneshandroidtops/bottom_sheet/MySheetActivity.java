package com.example.jigneshandroidtops.bottom_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityMySheetBinding;

public class MySheetActivity extends AppCompatActivity {

    private ActivityMySheetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMySheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSheet.setOnClickListener(view -> {

            MyBottomSheet sheet = new MyBottomSheet();

            sheet.show(getSupportFragmentManager(),"demo");

        });

    }
}