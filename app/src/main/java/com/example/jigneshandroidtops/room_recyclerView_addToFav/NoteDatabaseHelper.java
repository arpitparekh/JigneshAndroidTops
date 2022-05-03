package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import android.content.Context;

import androidx.room.Room;

public class NoteDatabaseHelper {

    static NoteDatabase getDatabase(Context context){

        NoteDatabase database = Room.databaseBuilder(context,NoteDatabase.class,"NoteDatabase")
                .allowMainThreadQueries()
                .build();

        return database;

    }

}
