package com.example.jigneshandroidtops.room_crud;

import android.content.Context;

import androidx.room.Room;

public class UtilityHelper {

    public static EmpDatabase database= null;

    public static EmpDatabase getDatabase(Context context){

        if(database==null){

            database = Room.databaseBuilder(context,
                    EmpDatabase.class,
                    "EmpDatabase")
                    .allowMainThreadQueries()
                    .build();
        }

        return database;

    }

}
