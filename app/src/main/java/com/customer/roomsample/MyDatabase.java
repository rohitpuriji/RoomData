package com.customer.roomsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {EmployeeModel.class, DeptModel.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract EmployeeDao getEmployeeDao();
    public abstract DepartmentDao getDepartmentDao();
}