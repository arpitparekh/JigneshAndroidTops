package com.example.jigneshandroidtops.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jigneshandroidtops.StoreFetchData;
import com.example.jigneshandroidtops.databinding.ActivityInternalStorageBinding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class InternalStorageActivity extends AppCompatActivity {

    private ActivityInternalStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStore.setOnClickListener(view -> {

            String data = binding.edtInternalStorage.getText().toString();

            StoreFetchData.storeData("hello.txt",this,data);

        });

        binding.btnFetch.setOnClickListener(view -> {

            binding.tvFetch.setText(StoreFetchData.readData("hello.txt",this));

        });

    }
}