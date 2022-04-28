package com.example.jigneshandroidtops.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.example.jigneshandroidtops.databinding.ActivityMyWebBinding;

public class MyWebActivity extends AppCompatActivity {

    private ActivityMyWebBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://stackoverflow.com/questions/26193475/paralax-effect-in-app-background");

        binding.webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {

        if(binding.webView.canGoBack()){
            binding.webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}