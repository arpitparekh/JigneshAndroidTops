package com.example.jigneshandroidtops.add_view_programmatically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jigneshandroidtops.databinding.ActivityMyBinding;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView tv = new TextView(this);
        tv.setText("This is TextView");
        tv.setTextSize(20.0f);

        binding.getRoot().addView(tv);

    }
}