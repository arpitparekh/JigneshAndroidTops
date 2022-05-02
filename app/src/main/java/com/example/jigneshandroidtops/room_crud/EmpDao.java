package com.example.jigneshandroidtops.room_crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmpDao {

    @Insert
    void insertData(Emp emp);

    @Update
    void updateData(Emp emp);

    @Delete
    void deleteData(Emp emp);

    @Query("select * from EmpTable")
    List<Emp> showData();

    @Query("select * from EmpTable where name=:empName")
    Emp getSingleEmpData(String empName);

    @Insert
    void insertMultipleData(List<Emp> list);

}
