package com.example.employeedetails.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.employeedetails.EmployeeDetailsApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeDetailsWorker(val context: Context,val params: WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        val repository=(context as EmployeeDetailsApplication).employeeDetailsRepository
        CoroutineScope(Dispatchers.Default).launch {
            repository.getEmployeeDataFromApiBackground()
        }

        return Result.success()
    }
}