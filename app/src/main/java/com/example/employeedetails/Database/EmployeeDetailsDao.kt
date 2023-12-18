package com.example.employeedetails.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDetailsDao {

    @Query("SELECT * FROM employee")
    fun getEmployeeDetails():LiveData<List<Employee>>

   @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEmployeeDetails(employeeDetails: List<Employee>)

}