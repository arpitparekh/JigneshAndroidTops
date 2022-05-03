package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityNoteListBinding;
import com.example.jigneshandroidtops.databinding.AddNoteDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    private ActivityNoteListBinding binding;
    private AddNoteDialogBinding dialogBinding;
    private NotesDao dao;
    private List<Note> list;
    private NoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvNotes.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        dao = NoteDatabaseHelper.getDatabase(this).getDao();

        refreshData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        dialogBinding = AddNoteDialogBinding.inflate(getLayoutInflater());

        if(item.getItemId()==R.id.action_add){

            new AlertDialog.Builder(this)
                    .setTitle("Please Add Notes")
                    .setView(dialogBinding.getRoot())
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String title = dialogBinding.edtTitle.getText().toString();
                            String des = dialogBinding.edtDes.getText().toString();

                            Note note = new Note(title,des);

                            dao.insertNote(note);

                            refreshData();

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();

                }
            }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }

    void refreshData(){

        list = dao.showNotes();
        adapter = new NoteAdapter(list);
        binding.rvNotes.setAdapter(adapter);

    }

}