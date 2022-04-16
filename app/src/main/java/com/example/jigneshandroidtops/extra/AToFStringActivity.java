package com.example.jigneshandroidtops.extra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityAtoFstringBinding;

import java.util.ArrayList;

public class AToFStringActivity extends AppCompatActivity {

    private ActivityAtoFstringBinding binding;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAtoFstringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add("Hello");
        list.add("Hi");
        list.add("Kem Cho");
        list.add("Sayonara");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcv,new TextFragment())
                .commit();

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                String data = list.get(pos);

                View v = binding.fcv;

               TextView tv =  v.findViewById(R.id.tv);

               tv.setText(data);

            }
        });

    }
}