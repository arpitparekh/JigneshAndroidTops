package com.example.jigneshandroidtops.firebase_realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.jigneshandroidtops.databinding.ActivityCarListBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CarListActivity extends AppCompatActivity {

    private ActivityCarListBinding binding;
    private DatabaseReference ref;
    private ArrayList<Car> list;
    private ArrayList<String> keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        keys = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("CarData").child("CarInfo");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                keys.clear();
                for( DataSnapshot childSnap : snapshot.getChildren()){

                    Car c = childSnap.getValue(Car.class);
                    String key = childSnap.getKey();

                    list.add(c);
                    keys.add(key);

                }
                ArrayAdapter<Car> adapter = new ArrayAdapter<>(CarListActivity.this, android.R.layout.simple_list_item_1,list);
                binding.listViewCar.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.btnSend.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String type = binding.edtType.getText().toString();

            Car car = new Car(name,type);

            ref.push().setValue(car).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(CarListActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(CarListActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });

    }
}