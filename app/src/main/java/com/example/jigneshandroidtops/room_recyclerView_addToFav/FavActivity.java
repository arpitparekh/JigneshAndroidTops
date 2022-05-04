package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.jigneshandroidtops.databinding.ActivityFavBinding;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity {

    private ActivityFavBinding binding;
    private NotesDao dao;
    private List<Note> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        dao = NoteDatabaseHelper.getDatabase(this).getDao();

        list = dao.showFavNotes(true);

        ArrayAdapter<Note> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listViewFavNotes.setAdapter(adapter);

    }
}