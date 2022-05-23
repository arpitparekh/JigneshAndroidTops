package com.example.jigneshandroidtops.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityProductListBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ActivityProductListBinding binding;
    private String status = "";
    private DatabaseReference reference;
    private ArrayList<Product> list;
    private ArrayList<String> keys;
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        keys = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listViewProduct.setAdapter(adapter);

        reference = FirebaseDatabase.getInstance().getReference("products");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                keys.clear();
                for(DataSnapshot childSnap : snapshot.getChildren()){

                    Product product =  childSnap.getValue(Product.class);
                    String key = childSnap.getKey();

                    list.add(product);
                    keys.add(key);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

               if(radioGroup.getCheckedRadioButtonId()== R.id.rbActive){
                   status = "active";
               }else if(radioGroup.getCheckedRadioButtonId()==R.id.rbDeActive){
                   status = "de-active";
               }

            }
        });

        binding.btnSubmit.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String price = binding.edtPrice.getText().toString();

            if(!name.isEmpty() && !price.isEmpty() && !status.isEmpty()){

                Product product = new Product(name,price,status);

                reference.push().setValue(product).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ProductListActivity.this, "Product Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProductListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }else{

                Toast.makeText(this, "Incomplete Field", Toast.LENGTH_SHORT).show();

            }

        });


    }
}