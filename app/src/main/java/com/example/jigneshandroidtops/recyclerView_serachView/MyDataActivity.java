package com.example.jigneshandroidtops.recyclerView_serachView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityMyDataBinding;

import java.util.ArrayList;

public class MyDataActivity extends AppCompatActivity {

    private ActivityMyDataBinding binding;
    private ArrayList<Data> list;
    DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new Data("tops","Cg road"));
        list.add(new Data("arena animation","Maninagar"));
        list.add(new Data("tops infosolution","Elise bridge"));
        list.add(new Data("Eco Solution","Sg Highway"));

        binding.rvDataList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DataAdapter(list);

        binding.rvDataList.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);


                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}