package com.customer.roomsample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DepartmentDao {

    @Query("SELECT * FROM Department")
    List<DeptModel> getDepartments();

    @Query("SELECT * FROM Department WHERE department =:aDeptName ")
    List<DeptModel> getDepartmentByName(String aDeptName);

    @Insert
    void insertDepartment(List<DeptModel> mDepartmentModelArrayList);

    @Query("DELETE FROM Department")
    void deleteAllDepartment();
}