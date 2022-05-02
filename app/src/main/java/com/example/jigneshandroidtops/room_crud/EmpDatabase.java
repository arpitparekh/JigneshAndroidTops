package com.example.jigneshandroidtops.room_crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Emp.class},version = 1,exportSchema = false)
abstract public class EmpDatabase extends RoomDatabase {
    public abstract EmpDao getInterfaceObject();
}
