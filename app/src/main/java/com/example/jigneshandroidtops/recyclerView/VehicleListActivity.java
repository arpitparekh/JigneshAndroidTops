package com.example.jigneshandroidtops.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityVehicleListBinding;

import java.util.ArrayList;

public class VehicleListActivity extends AppCompatActivity {

    private ActivityVehicleListBinding binding;
    private ArrayList<Vehicle> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVehicleListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // linear // grid layout // staggered grid

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        list.add(new Vehicle("Honda",50));
        list.add(new Vehicle("Pulser",40));
        list.add(new Vehicle("Avenger",32));

        // make adapter

        VehicleAdapter adapter = new VehicleAdapter(list);

        binding.recyclerView.setAdapter(adapter);



    }
}