package com.example.jigneshandroidtops.room_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivityEmpListBinding;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding binding;
    private List<Emp> empList;
    private EmpDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.rvEmpList.setLayoutManager(new LinearLayoutManager(this));

        empList = new ArrayList<>();

        EmpDatabase database = UtilityHelper.getDatabase(this);

        dao =  database.getInterfaceObject();

        getData();

        binding.btnStore.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Emp e = new Emp(name,address);

            dao.insertData(e);

            getData();

        });
    }
    void getData(){

        empList = dao.showData();

        ArrayAdapter<Emp> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,empList);

        binding.listView.setAdapter(adapter);

    }
}