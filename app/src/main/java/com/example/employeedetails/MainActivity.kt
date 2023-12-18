package com.example.employeedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var employeeViewModel: EmployeeDetailsViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var employeeDetailsAdapter: EmployeeDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        employeeViewModel = ViewModelProvider(this, EmployeeDetailsViewModelFactory(applicationContext)).get(
            EmployeeDetailsViewModel::class.java
        )
       // employeeViewModel.getEmployeeInfoFromApi()

        recyclerView = findViewById(R.id.recyclerView)
        employeeViewModel.getEmployeeDetailsFromDatabase().observe(this) {
            employeeDetailsAdapter = EmployeeDetailsAdapter(it);
            recyclerView.adapter = employeeDetailsAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.hasFixedSize()
        }

    }
}