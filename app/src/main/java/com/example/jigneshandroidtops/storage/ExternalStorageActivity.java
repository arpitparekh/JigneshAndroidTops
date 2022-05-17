package com.example.jigneshandroidtops.storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.example.jigneshandroidtops.databinding.ActivityExternalStorageBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExternalStorageActivity extends AppCompatActivity {

    private ActivityExternalStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkExternalPermission();

        binding.btnSend.setOnClickListener(view -> {

            checkExternalPermission();

            String data = binding.edtExternal.getText().toString();

            File rootFolder = Environment.getExternalStorageDirectory();

            File subFolder = new File(rootFolder,"demoFolder");

            subFolder.mkdir();

            File file = new File(subFolder,"hello.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Written Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.i("error",e.toString());
            }


        });


        binding.btnReceive.setOnClickListener(view -> {

            checkExternalPermission();

            File rootFolder = Environment.getExternalStorageDirectory();

            File subFolder = new File(rootFolder,"demoFolder");

            subFolder.mkdir();

            File file = new File(subFolder,"hello.txt");

            try {

                FileInputStream fis = new FileInputStream(file);
                byte arr[] = new byte[fis.available()];

                fis.read(arr);

                String receiveData = new String(arr);

                binding.tvExternal.setText(receiveData);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    private void checkExternalPermission() {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

            if(!Environment.isExternalStorageManager()){

                Intent i = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                i.setData(Uri.fromParts("package",getPackageName(),null));
                startActivity(i);


            }else{

            }

        }else{

            if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
            }else{
                Toast.makeText(this, "Permission is Already Granted", Toast.LENGTH_SHORT).show();
            }
        }



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this, "Permission Accepted", Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

            }

        }

    }
}