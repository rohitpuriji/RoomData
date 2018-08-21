package com.customer.roomsample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    List<EmployeeModel> getEmployees();

    @Insert
    void insertStudent(List<EmployeeModel> mEmployeeModelArrayList);

    @Query("SELECT * FROM Employee WHERE name LIKE 'A%';")
    List<EmployeeModel> getEmployeeWithStart();

    @Query("SELECT * FROM Employee WHERE name LIKE '%hi%';")
    List<EmployeeModel> getEmployeeWithAnywhere();


    @Query("SELECT * FROM Employee WHERE salary > 10000")
    List<EmployeeModel> getEmployeeWithSalary();


    @Query("select * from Employee where salary = (select max(salary) from Employee where salary < (select max(salary)  from Employee))")
    List<EmployeeModel> getEmployeeWith2Salary();


    @Query("SELECT * FROM employee INNER JOIN department WHERE salary = (select max(salary)) AND department LIKE 'sales'")
    List<EmployeeModel> getEmployeeWith2SalarywithSales();


}