package com.customer.roomsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Employee")
public class EmployeeModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String mName;

    @ColumnInfo (name = "salary")
    public String mSalary;


    @ForeignKey(entity = DeptModel.class, parentColumns = "id", childColumns = "deptId")
    public String deptId;

    public String getmDeptId() {
        return deptId;
    }

    public void setmDeptId(String deptId) {
        this.deptId = deptId;
    }

    public int getmId() {
        return id;
    }

    public void setmId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSalary() {
        return mSalary;
    }

    public void setmSalary(String mSalary) {
        this.mSalary = mSalary;
    }

}