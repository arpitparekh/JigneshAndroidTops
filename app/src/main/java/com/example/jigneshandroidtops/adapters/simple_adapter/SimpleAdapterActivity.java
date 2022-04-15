package com.example.jigneshandroidtops.adapters.simple_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivitySimpleAdapterBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends AppCompatActivity {

    private ActivitySimpleAdapterBinding binding;
    private ArrayList<HashMap<String,String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySimpleAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        HashMap<String,String> map = new HashMap<>();
        map.put("Name","Jignesh");
        map.put("Address","Ahmedabad");

        list.add(map);

        HashMap<String,String> map2 = new HashMap<>();
        map2.put("Name","Arpit");
        map2.put("Address","Surat");

        list.add(map2);

        String[] from ={"Name","Address"};
        int[] to = {R.id.tvName,R.id.tvAddress};


        SimpleAdapter adapter = new SimpleAdapter(this,list, R.layout.simple_adapter_items,from,to);

        binding.listView.setAdapter(adapter);
    }
}