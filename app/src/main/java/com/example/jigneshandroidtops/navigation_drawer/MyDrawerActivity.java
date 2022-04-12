package com.example.jigneshandroidtops.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityMyDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class MyDrawerActivity extends AppCompatActivity {

    private ActivityMyDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        // click in navigation view items

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // click on each and every item using item.getItemId()

                return false;
            }
        });

        // click on heardLayout child

        View v =  binding.navigationView.getHeaderView(0);

        ImageView iv = v.findViewById(R.id.ivProfile);

        TextView tv = v.findViewById(R.id.tvName);

        TextView tv2 = v.findViewById(R.id.tvEmail);


        // toolbar navigation icon click

        binding.toolbar.setNavigationOnClickListener(view -> {

            binding.getRoot().openDrawer(Gravity.RIGHT);

        });


        // menu in toolbar click

        binding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });




    }
}