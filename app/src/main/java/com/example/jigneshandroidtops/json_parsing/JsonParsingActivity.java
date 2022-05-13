package com.example.jigneshandroidtops.json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivityJsonParsingBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonParsingActivity extends AppCompatActivity {

    private ActivityJsonParsingBinding binding;
    private ArrayList<News> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJsonParsingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();



        // https://jsonplaceholder.typicode.com/posts

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();
//        Handler handler = new Handler();

        executor.execute(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();

                try {

                    Response response = client.newCall(request).execute();

                    Log.i("response",response.body().string());

                    String json = response.body().string();



                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            JSONArray jsonArray = null;
                            try {

                                jsonArray = new JSONArray(json);

                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    String title =  jsonObject.getString("title");
                                    String body =  jsonObject.getString("body");

                                    News news = new News(title,body);

                                    list.add(news);

                                    Log.i("response",list.toString());

                                }

                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       ArrayAdapter<News> adapter = new ArrayAdapter<>(JsonParsingActivity.this,
                                               android.R.layout.simple_list_item_1,list);
                                       binding.listViewJson.setAdapter(adapter);
                                   }
                               });



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}