package com.example.employeedetails

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmployeeDetailsViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeDetailsViewModel((context as EmployeeDetailsApplication).employeeDetailsRepository ) as T
    }
}