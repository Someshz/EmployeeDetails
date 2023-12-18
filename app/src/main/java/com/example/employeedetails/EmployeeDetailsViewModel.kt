package com.example.employeedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.employeedetails.Database.Employee
import com.example.employeedetails.Repository.EmployeeDetailsRepository

class EmployeeDetailsViewModel(
    val employeeDetailsRepository: EmployeeDetailsRepository,
) : ViewModel() {


//    fun getEmployeeInfoFromApi() {
//        CoroutineScope(Dispatchers.IO).launch {
//            employeeDetailsRepository.getEmployeeDataFromApi()
//        }
//    }

    fun getEmployeeDetailsFromDatabase(): LiveData<List<Employee>> {
       return employeeDetailsRepository.getDataFromDataBase()
    }

}