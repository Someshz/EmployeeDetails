package com.example.employeedetails.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EmployeeDetailsHelper {

    val BASE_URL = "https://dummy.restapiexample.com/"

    fun getInstance(): Retrofit {
        // val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}