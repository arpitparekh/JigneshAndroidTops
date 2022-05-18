package com.example.jigneshandroidtops.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityMySharedBinding;

public class MySharedActivity extends AppCompatActivity {

    private ActivityMySharedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMySharedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStore.setOnClickListener(view -> {

            SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("number",23);
            editor.putString("string","tops");
            editor.putLong("long",343434343445l);
            editor.apply();

        });

        binding.btnFetch.setOnClickListener(view -> {

            SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
            int number =  sharedPreferences.getInt("number",0);
            binding.tvFetch.setText(String.valueOf(number));

        });
        binding.btnClear.setOnClickListener(view -> {

            SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
        });


    }
}