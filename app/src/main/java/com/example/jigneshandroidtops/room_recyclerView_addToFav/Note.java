package com.example.jigneshandroidtops.room_recyclerView_addToFav;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    int key;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "des")
    String des;

    @ColumnInfo(name = "status")
    boolean fav = false;

    public Note(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
