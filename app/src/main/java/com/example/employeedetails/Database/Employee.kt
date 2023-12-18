package com.example.employeedetails.Database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "employee")
data class Employee(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val profile_image: String
)