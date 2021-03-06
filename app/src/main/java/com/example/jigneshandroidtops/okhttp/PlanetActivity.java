package com.example.jigneshandroidtops.okhttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.jigneshandroidtops.databinding.ActivityPlanetBinding;
import com.example.jigneshandroidtops.okhttp.gson.ItemsItem;
import com.example.jigneshandroidtops.okhttp.gson.Solar;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlanetActivity extends AppCompatActivity {

    private ActivityPlanetBinding binding;
    private List<ItemsItem> list;
    private PlanetAdapter adapter;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlanetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gson = new Gson();

        list = new ArrayList<>();
        binding.recyclerViewPlanet.setLayoutManager(new LinearLayoutManager(this));

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://planets-info-by-newbapi.p.rapidapi.com/api/v1/planet/list")
                .addHeader("X-RapidAPI-Host", "planets-info-by-newbapi.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077")
                .build();

        Call call =  client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

//                Log.i("response",response.body().string());

                String json = response.body().string();

                Solar solar = gson.fromJson(json,Solar.class);  // JSON TO JAVA OBJECT

                list = solar.getItems();

//
//                try {
//
//                    JSONObject object = new JSONObject(json);
//
//                    JSONArray items = object.getJSONArray("_items");
//
//                    for(int i=0;i<items.length();i++){
//
//                        JSONObject innerObject = items.getJSONObject(i);
//
//                        String name = innerObject.getString("name");
//                        String des = innerObject.getString("description");
//
//                        JSONArray innerArray = innerObject.getJSONArray("imgSrc");
//
//                        JSONObject imgObject =  innerArray.getJSONObject(0);
//
//                        String img = imgObject.getString("img");
//


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshAdapter();
                        }
                    });
            }
        });
    }

    void refreshAdapter(){
        adapter = new PlanetAdapter(list);
        binding.recyclerViewPlanet.setAdapter(adapter);
    }
}