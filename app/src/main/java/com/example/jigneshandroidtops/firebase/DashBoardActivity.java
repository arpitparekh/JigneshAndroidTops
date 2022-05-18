package com.example.jigneshandroidtops.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jigneshandroidtops.databinding.ActivityDashBoardBinding;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoardBinding binding;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.btnLogout.setOnClickListener(view -> {

            auth.signOut();

            startActivity(new Intent(DashBoardActivity.this,LoginActivity.class));
        });
    }
}