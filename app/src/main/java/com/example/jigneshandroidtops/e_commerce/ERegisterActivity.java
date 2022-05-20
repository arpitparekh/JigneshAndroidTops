package com.example.jigneshandroidtops.e_commerce;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityEregisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ERegisterActivity extends AppCompatActivity {

    private ActivityEregisterBinding binding;
    private FirebaseAuth auth;
    private StorageReference storageRef;
    private DatabaseReference databaseRef;
    private Uri imageUri;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEregisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading Data...");
        dialog.setMessage("Please Wait..");

        auth = FirebaseAuth.getInstance();

        databaseRef = FirebaseDatabase.getInstance().getReference("users");

        ////////////////////////////////////    profile image  ////////////////////////////////////////

        ActivityResultLauncher<String> gallery = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                binding.ivProfile.setImageURI(result);
                imageUri = result;
            }
        }) ;

        binding.ivProfile.setOnClickListener(view -> {

            gallery.launch("image/*");

        });

        ///////////////////////////////////////////////////////////////////////////////////////////////

        binding.btnRegister.setOnClickListener(view -> {

            dialog.show();

            String name = binding.edtName.getText().toString();
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String repeat = binding.edtRepeat.getText().toString();
            String phone = binding.edtPhone.getText().toString();

            if(!email.isEmpty() && !password.isEmpty() && !repeat.isEmpty() && !phone.isEmpty() && password.equals(repeat) && imageUri!=null){

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                String uid = auth.getCurrentUser().getUid();

                                storageRef = FirebaseStorage.getInstance().getReference("userProfile").child(uid);

                                storageRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                            @Override
                                            public void onSuccess(Uri uri) {

                                                String url = uri.toString();

                                                User user = new User(uid,name,email,phone,url);

                                                databaseRef.push().setValue(user)
                                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void unused) {

                                                                dialog.dismiss();

                                                                Toast.makeText(ERegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();

                                                                Intent intent = new Intent(ERegisterActivity.this,ELoginActivity.class);
                                                                startActivity(intent);

                                                            }
                                                        }).addOnFailureListener(new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(@NonNull Exception e) {

                                                            }
                                                        });

                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {



                                            }
                                        });


                                    }
                                })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {

                                            }
                                        });
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