package com.example.employeedetails.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.employeedetails.Api.EmployeeDetailsService
import com.example.employeedetails.Database.Employee
import com.example.employeedetails.Database.EmployeeDatabase

class EmployeeDetailsRepository(
    private val employeeDetailsService: EmployeeDetailsService,
    private val employeeDatabase: EmployeeDatabase
) {

//    suspend fun getEmployeeDataFromApi() {
//        val result = employeeDetailsService.getEmployeeData()
//        if (result?.body() != null) {
//            val data: List<Employee> = result!!.body()!!.data;
//            employeeDatabase.getDao().insertEmployeeDetails(data)
//        }
//    }

    fun getDataFromDataBase(): LiveData<List<Employee>> {
        return employeeDatabase.getDao().getEmployeeDetails()
    }

    suspend fun getEmployeeDataFromApiBackground() {
        val result = employeeDetailsService.getEmployeeData()
        if (result?.body() != null) {
            val data: List<Employee> = result!!.body()!!.data;
            Log.d("Call 15 minute", "15 Minutes")
            employeeDatabase.getDao().insertEmployeeDetails(data)
        }
    }
}



