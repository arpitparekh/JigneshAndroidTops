package com.example.jigneshandroidtops.room_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivityEmpListBinding;
import com.example.jigneshandroidtops.databinding.UpdateEmpDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding binding;
    private UpdateEmpDialogBinding dialogBinding;
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

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                dialogBinding = UpdateEmpDialogBinding.inflate(getLayoutInflater());

                Emp e = empList.get(pos);

                dialogBinding.edtEmpNameUpdate.setText(e.name);
                dialogBinding.edtEmpAddressUpdate.setText(e.address);

                new AlertDialog.Builder(EmpListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // update

                                new AlertDialog.Builder(EmpListActivity.this)
                                        .setTitle("Update Data")
                                        .setView(dialogBinding.getRoot())
                                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                String name = dialogBinding.edtEmpNameUpdate.getText().toString();
                                                String address = dialogBinding.edtEmpAddressUpdate.getText().toString();

                                                e.name = name;
                                                e.address = address;

                                                dao.updateData(e);

                                                getData();

                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        }).create().show();


                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // delete

                                deleteEmpData(e);

                            }
                        })
                        .setNeutralButton("Send", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // send

                                Intent intent = new Intent(EmpListActivity.this,ShowEmpDataActivity.class);
                                intent.putExtra("obj",e);
                                startActivity(intent);

                            }
                        })
                        .create().show();

            }
        });

        binding.btnStore.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Emp e = new Emp(name,address);

            dao.insertData(e);

            getData();

            reset();
        });
    }

    private void deleteEmpData(Emp e) {

        dao.deleteData(e);

        getData();

    }

    void getData(){

        empList = dao.showData();

        ArrayAdapter<Emp> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,empList);

        binding.listView.setAdapter(adapter);
    }

    void reset(){

        binding.edtName.setText("");
        binding.edtAddress.setText("");

    }
}