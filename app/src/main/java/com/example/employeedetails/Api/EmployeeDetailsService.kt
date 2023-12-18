package com.example.employeedetails.Api

import com.example.employeedetails.model.EmployeeDetails
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeDetailsService {

    @GET("/api/v1/employees")
    suspend fun getEmployeeData():Response<EmployeeDetails>
}