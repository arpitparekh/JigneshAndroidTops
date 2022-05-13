package com.example.jigneshandroidtops.room_crud_foreignkey;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "BooksTable")
public class Books {

    int book_id;

    @ColumnInfo(name = "BookName")
    String bookName;

    public Books(int book_id, String bookName) {
        this.book_id = book_id;
        this.bookName = bookName;
    }
}
