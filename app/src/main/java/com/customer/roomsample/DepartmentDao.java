package com.customer.roomsample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DepartmentDao {

    @Query("SELECT * FROM Department")
    List<DeptModel> getDepartments();

    @Insert
    void insertDepartment(List<DeptModel> mDepartmentModelArrayList);


}