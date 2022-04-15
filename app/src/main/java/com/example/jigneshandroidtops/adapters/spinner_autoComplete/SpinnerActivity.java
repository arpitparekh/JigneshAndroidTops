package com.example.jigneshandroidtops.adapters.spinner_autoComplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivitySpinnerBinding;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    private ActivitySpinnerBinding binding;
    private ArrayList<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cities = new ArrayList<>();

        cities.add(new City("Ahmedabad",12000000));
        cities.add(new City("Surat",1500000));
        cities.add(new City("Goa",220000));
        cities.add(new City("Rajkot",720000));

        ArrayAdapter<City> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cities);

        binding.spinner.setAdapter(adapter);

        binding.autoComplete.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

              City city = cities.get(pos);

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

    }
}