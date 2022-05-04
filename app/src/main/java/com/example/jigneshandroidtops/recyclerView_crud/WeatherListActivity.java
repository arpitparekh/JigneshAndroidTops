package com.example.jigneshandroidtops.recyclerView_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jigneshandroidtops.databinding.ActivityWeatherListBinding;

import java.util.ArrayList;

public class WeatherListActivity extends AppCompatActivity implements WeatherAdapter.OnWeatherItemClickInterface {

    private ActivityWeatherListBinding binding;
    private ArrayList<Weather> list;
    private boolean bool = false;
    private int pos = 0;
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        adapter = new WeatherAdapter(list, this);

        binding.rvWeather.setAdapter(adapter);


        binding.rvWeather.setLayoutManager(new LinearLayoutManager(this));  // linear vertical
//        binding.rvWeather.setLayoutManager(new GridLayoutManager(this,2));
//        binding.rvWeather.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
//        binding.rvWeather.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        binding.rvWeather.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.HORIZONTAL));


        binding.btnAdd.setOnClickListener(view -> {

            if (bool) {

                // update

                String name = binding.edtName.getText().toString();
                float temp = Float.parseFloat(binding.edtTemp.getText().toString());
                float wind = Float.parseFloat(binding.edtWind.getText().toString());

                Weather w = new Weather(name, temp, wind);

                list.set(pos, w);

                adapter.notifyDataSetChanged();

                reset();

                bool = false;

                binding.btnAdd.setText("Add");


            } else {

                // insert

                String name = binding.edtName.getText().toString();
                float temp = Float.parseFloat(binding.edtTemp.getText().toString());
                float wind = Float.parseFloat(binding.edtWind.getText().toString());

                Weather w = new Weather(name, temp, wind);

                list.add(w);

                adapter.notifyDataSetChanged();

                reset();
            }
        });


    }

    void reset() {

        binding.edtName.setText("");
        binding.edtTemp.setText("");
        binding.edtWind.setText("");

    }

    @Override
    public void onClick(int position) {

        Weather w = list.get(position);

//        Toast.makeText(this,w.name, Toast.LENGTH_SHORT).show();

        new AlertDialog.Builder(this)
                .setTitle("Choose One")
                .setMessage("Update Or Delete")
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // update

                        binding.edtTemp.setText(String.valueOf(w.temp));
                        binding.edtName.setText(w.name);
                        binding.edtWind.setText(String.valueOf(w.wind_speed));

                        binding.btnAdd.setText("Update");

                        bool = true;

                        pos = position;

                    }
                }).setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // delete

                list.remove(position);

                adapter.notifyDataSetChanged();

            }
        }).create().show();

    }
}