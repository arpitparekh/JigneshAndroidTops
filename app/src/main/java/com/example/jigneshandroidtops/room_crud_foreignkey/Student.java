package com.example.jigneshandroidtops.room_crud_foreignkey;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentTable")
public class Student {

    @PrimaryKey
    int student_id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "address")
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int student_id, String name, String address) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
    }
}
