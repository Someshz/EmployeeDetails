package com.example.employeedetails.model

import com.example.employeedetails.Database.Employee

data class EmployeeDetails(
    val data: List<Employee>,
    val message: String,
    val status: String
)