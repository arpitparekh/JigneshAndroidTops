package com.example.jigneshandroidtops.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityEloginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ELoginActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private ActivityEloginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEloginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.tvNewUser.setOnClickListener(view -> {

            startActivity(new Intent(this,ERegisterActivity.class));

        });

        binding.btnLogin.setOnClickListener(view -> {

            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()){

                auth.signInWithEmailAndPassword(email,password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                Toast.makeText(ELoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

            }

        });

    }
}