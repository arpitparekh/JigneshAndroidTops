package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1,exportSchema = false)
abstract public class NoteDatabase extends RoomDatabase {

     public abstract NotesDao getDao();

}
