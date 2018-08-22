package com.customer.roomsample;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final MyDatabase myDatabase = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "College-db").build();

        Button btnPrintAllEmp = findViewById(R.id.btnPrintAllEmp);
        Button btnPrintAllDept = findViewById(R.id.btnPrintAllDept);
        Button btnPrintNameWith = findViewById(R.id.btnPrintNameWith);
        Button btnPrintAllEmpSalary = findViewById(R.id.btnPrintAllEmpSalary);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnPrint2High = findViewById(R.id.btnPrint2High);
        Button btnPrintAllEmpHi = findViewById(R.id.btnPrintAllEmpHi);
        Button btnPrintEmpDetails = findViewById(R.id.btnPrintEmpDetails);



        btnPrintEmpDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,6);
            }
        });


        btnPrintAllDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printDept(myDatabase);
            }
        });

        btnPrintAllEmpSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,3);
            }
        });

        btnPrint2High.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,4);
            }
        });

        btnPrintAllEmpHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,5);
            }
        });


        btnPrintAllEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,1);
            }
        });

        btnPrintNameWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printEmployees(myDatabase,2);
            }
        });

        final ArrayList<EmployeeModel> modelArrayList = new ArrayList<>();
        //Saving some records
        EmployeeModel sEmployeeModel = new EmployeeModel();
        sEmployeeModel.setmName("Rohit Puri");
        sEmployeeModel.setmSalary("18000");
        sEmployeeModel.setmDeptId("101");
        modelArrayList.add(sEmployeeModel);

        EmployeeModel mStudentModel2 = new EmployeeModel();
        mStudentModel2.setmName("Tarun Joshi");
        mStudentModel2.setmSalary("22000");
        mStudentModel2.setmDeptId("102");
        modelArrayList.add(mStudentModel2);

        EmployeeModel mStudentModel3 = new EmployeeModel();
        mStudentModel3.setmName("Mohit Bisht");
        mStudentModel3.setmSalary("15000");
        mStudentModel3.setmDeptId("101");
        modelArrayList.add(mStudentModel3);

        EmployeeModel mStudentModel4 = new EmployeeModel();
        mStudentModel4.setmName("Arvind Kumar");
        mStudentModel4.setmSalary("7000");
        mStudentModel4.setmDeptId("104");
        modelArrayList.add(mStudentModel4);


        final ArrayList<DeptModel> deptArrayList = new ArrayList<>();
        //Saving some records
        DeptModel sDeptModel = new DeptModel();
        sDeptModel.setmDeptName("Sales");
        deptArrayList.add(sDeptModel);

        DeptModel sDeptModel2 = new DeptModel();
        sDeptModel2.setmDeptName("HR");
        deptArrayList.add(sDeptModel2);

        DeptModel sDeptModel3 = new DeptModel();
        sDeptModel3.setmDeptName("Sales");
        deptArrayList.add(sDeptModel3);

        DeptModel sDeptMode4 = new DeptModel();
        sDeptMode4.setmDeptName("Networking");
        deptArrayList.add(sDeptMode4);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmployees(myDatabase,modelArrayList);
                addDepartments(myDatabase,deptArrayList);
            }
        });

    }

    private void addDepartments(final MyDatabase myDatabase, final ArrayList<DeptModel> deptArrayList) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                myDatabase.getDepartmentDao().insertDepartment(deptArrayList);

                return null;
            }

            @Override
            protected void onPostExecute(Void agentsCount) {
                Log.e("dept added :","yes");
            }
        }.execute();
    }

    private void printEmployees(final MyDatabase myDatabase, final int i){

        new AsyncTask<Void, Void, Void>() {
            ArrayList<EmployeeModel> arrayList = new ArrayList<>();
            String empName;
            @Override
            protected Void doInBackground(Void... params) {
                switch (i){
                    case 1:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmployees();
                        break;

                    case 2:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmployeeWithStart();
                        break;

                    case 3:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmployeeWithSalary();
                        break;

                    case 4:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmployeeWith2Salary();
                        break;

                    case 5:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmployeeWithAnywhere();
                        break;

                    case 6:
                        arrayList =   (ArrayList<EmployeeModel>) myDatabase.getEmployeeDao().getEmpDepartWithSales("101");
                        break;
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void agentsCount) {
                Log.e("employee size :",arrayList.size()+"");

                for (int i=0;i<arrayList.size();i++){
                    Log.e("employee name :",arrayList.get(i).mName+" :::");
                }

            }
        }.execute();
    }


    private void printDept(final MyDatabase myDatabase){

        new AsyncTask<Void, Void, Void>() {
            ArrayList<DeptModel> arrayList = new ArrayList<>();

            @Override
            protected Void doInBackground(Void... params) {
                arrayList =   (ArrayList<DeptModel>) myDatabase.getDepartmentDao().getDepartments();

                return null;
            }

            @Override
            protected void onPostExecute(Void agentsCount) {
                Log.e("dept size :",arrayList.size()+"");

                for (int i=0;i<arrayList.size();i++){
                    Log.e("dept name :",arrayList.get(i).mDeptName+" :::");
                }

            }
        }.execute();
    }

    private void addEmployees(final MyDatabase myDatabase, final ArrayList<EmployeeModel> modelArrayList){

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                myDatabase.getEmployeeDao().insertStudent(modelArrayList);

                return null;
            }

            @Override
            protected void onPostExecute(Void agentsCount) {
                Log.e("employee added :","yes");
            }
        }.execute();
    }

}
