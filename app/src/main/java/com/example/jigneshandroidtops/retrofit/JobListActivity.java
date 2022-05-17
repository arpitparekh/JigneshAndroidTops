package com.example.jigneshandroidtops.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivityJobListBinding;
import com.example.jigneshandroidtops.retrofit.classes.Job;
import com.example.jigneshandroidtops.retrofit.classes.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobListActivity extends AppCompatActivity {

    private ActivityJobListBinding binding;
    private List<ResultsItem> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        results = new ArrayList<>();

        Call<Job> call = ApiHelper.getApiInstance().getJobData("India");

        call.enqueue(new Callback<Job>() {
            @Override
            public void onResponse(Call<Job> call, Response<Job> response) {
                Log.i("response",response.body().toString());

                Job job = response.body();
                results = job.getResults();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<ResultsItem> adapter = new ArrayAdapter<>(JobListActivity.this, android.R.layout.simple_list_item_1,results);
                        binding.listViewJob.setAdapter(adapter);
                    }
                });
            }
            @Override
            public void onFailure(Call<Job> call, Throwable t) {
            }
        });

    }
}