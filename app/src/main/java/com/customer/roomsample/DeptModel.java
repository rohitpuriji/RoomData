package com.customer.roomsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Department")
public class DeptModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "department")
    public String mDeptName;

    public int getmId() {
        return id;
    }

    public void setmId(int id) {
        this.id = id;
    }

    public String getmDeptName() {
        return mDeptName;
    }

    public void setmDeptName(String mDeptName) {
        this.mDeptName = mDeptName;
    }

}
