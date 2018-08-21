package com.customer.roomsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Employee")
public class EmployeeModel {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "name")
    public String mName;

    @ColumnInfo (name = "salary")
    public String mSalary;

    @ColumnInfo (name = "deptid")
    public String mDeptId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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

    public String getmDeptId() {
        return mDeptId;
    }

    public void setmDeptId(String mDeptId) {
        this.mDeptId = mDeptId;
    }
}