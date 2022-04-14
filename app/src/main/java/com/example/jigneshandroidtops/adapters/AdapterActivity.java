package com.example.jigneshandroidtops.adapters;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityAdapterBinding;
import com.example.jigneshandroidtops.databinding.UpdateDialogLayoutBinding;

import java.util.ArrayList;

public class AdapterActivity extends AppCompatActivity {

    private ActivityAdapterBinding binding;
    private UpdateDialogLayoutBinding binding1;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, R.layout.listview_items,list);

        binding.listView.setAdapter(adapter);

        binding.btnAdd.setOnClickListener(view -> {

            String note = binding.edtNote.getText().toString();

            list.add(note);

            // adapters

            // ArrayAdapter   // listView
            // Simple Adapter  // listview
            // RecyclerView Adapter

            adapter.notifyDataSetChanged();

            binding.edtNote.setText("");

        });

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                // pos = 0

                binding1 = UpdateDialogLayoutBinding.inflate(getLayoutInflater());



                String note = list.get(pos);

                binding1.edtUpdateNote.setText(note);

                AlertDialog.Builder builder = new AlertDialog.Builder(AdapterActivity.this);

                builder.setTitle("Choose One");

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // update

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(AdapterActivity.this);

                        builder1.setTitle("Update");

                        builder1.setView(binding1.getRoot());

                        builder1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String newString =  binding1.edtUpdateNote.getText().toString();

                                list.set(pos,newString);

                                adapter.notifyDataSetChanged();

                            }
                        });

                        builder1.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                        builder1.show();

                    }
                });

                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // delete

                        list.remove(pos);

                        adapter.notifyDataSetChanged(); // refresh adapter

                    }
                });

                builder.show();

            }
        });

    }
}