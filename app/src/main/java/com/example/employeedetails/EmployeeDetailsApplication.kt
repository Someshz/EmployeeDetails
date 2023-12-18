package com.example.employeedetails

import android.app.Application
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.employeedetails.Api.EmployeeDetailsHelper
import com.example.employeedetails.Api.EmployeeDetailsService
import com.example.employeedetails.Database.EmployeeDatabase
import com.example.employeedetails.Repository.EmployeeDetailsRepository
import com.example.employeedetails.workmanager.EmployeeDetailsWorker
import java.util.concurrent.TimeUnit

class EmployeeDetailsApplication : Application() {

    lateinit var employeeDetailsRepository: EmployeeDetailsRepository
    override fun onCreate() {
        super.onCreate()
        initilize()
        setWorker()
    }

    fun initilize() {
        val employeeDetailsService = EmployeeDetailsHelper.getInstance().create(
            EmployeeDetailsService::class.java
        )
        val employeeDatabase = EmployeeDatabase.getDatabase(applicationContext)
        employeeDetailsRepository =
            EmployeeDetailsRepository(employeeDetailsService, employeeDatabase)

    }

    fun setWorker() {
        val constraint =
            androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workRequest =
            PeriodicWorkRequest.Builder(EmployeeDetailsWorker::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(constraint)
                .build();
        WorkManager.getInstance(this).enqueue(workRequest);
    }

}