package com.example.jigneshandroidtops.activity_result;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.jigneshandroidtops.databinding.ActivityMyResultBinding;

import java.util.List;
import java.util.Map;

public class MyResultActivity extends AppCompatActivity {

    private ActivityMyResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<String> launcher1 = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                    binding.ivPic.setImageURI(result);
            }
        });

        ActivityResultLauncher<String> launcher2 = registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback<List<Uri>>() {
            @Override
            public void onActivityResult(List<Uri> result) {
                binding.ivPic.setImageURI(result.get(0));
                binding.imageView3.setImageURI(result.get(1));
                binding.imageView4.setImageURI(result.get(2));
            }
        });

        ActivityResultLauncher<String> launcher3 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if(result){
                    Toast.makeText(MyResultActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MyResultActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ActivityResultLauncher<String[]> launcher4 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {

                for(Map.Entry<String,Boolean> entry : result.entrySet() ){

                    if(entry.getKey().equals(Manifest.permission.CAMERA)){

                        if(entry.getValue()){
                            Toast.makeText(MyResultActivity.this, "Camera Granted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MyResultActivity.this, "Camera Denied", Toast.LENGTH_SHORT).show();
                        }

                    }
                    if(entry.getKey().equals(Manifest.permission.READ_CONTACTS)){

                        if(entry.getValue()){
                            Toast.makeText(MyResultActivity.this, "Contact Granted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MyResultActivity.this, "Contact Denied", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            }
        });

        ActivityResultLauncher<Intent> launcher5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Uri uri = result.getData().getData();

                binding.imageView5.setImageURI(uri);
            }
        });

        binding.ivPic.setOnClickListener(view -> {

            launcher2.launch("image/*");

        });

        binding.btnPermission.setOnClickListener(view -> {

            launcher3.launch(Manifest.permission.CAMERA);

        });

        binding.btnPermissions.setOnClickListener(view -> {
            launcher4.launch(new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS});
        });

        binding.imageView5.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_PICK);
            i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcher5.launch(i);

        });



    }

//    @Override    old method
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}