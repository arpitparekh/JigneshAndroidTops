package com.example.jigneshandroidtops.room_crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "EmpTable")
public class Emp implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int key;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "address")
    String address;


    public Emp(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name= " + name+
                "\naddress= " + address ;
    }
}
