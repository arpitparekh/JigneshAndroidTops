package com.example.jigneshandroidtops.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;

import com.example.jigneshandroidtops.databinding.ActivityImplicitBinding;

public class ImplicitActivity extends AppCompatActivity {

    private ActivityImplicitBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImplicitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Implicit intent

        binding.btnCamera.setOnClickListener(view -> {

            // provide intent actions
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(i);

        });

        binding.btnSettings.setOnClickListener(view -> {

            Intent i = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
            startActivity(i);

        });

        binding.btnMail.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_APP_EMAIL);
            startActivity(i);

        });

        binding.btnHome.setOnClickListener(view -> {

            Intent i =new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);

        });

        binding.btnDialer.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919601397062"));
            startActivity(i);

        });

        binding.btnSendMail.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:arpitparekh9@gmail.com"));
            i.putExtra(Intent.EXTRA_SUBJECT,"Hello");
            startActivity(i);


        });
    }
}