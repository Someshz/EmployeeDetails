package com.example.employeedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedetails.Database.Employee

class EmployeeDetailsAdapter(val data:List<Employee>) : RecyclerView.Adapter<EmployeeDetailsAdapter.EmployeeDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeDetailsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_details, parent, false)

        return EmployeeDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeDetailsViewHolder, position: Int) {
            val employee:Employee=data[position]
            holder.bind(employee)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EmployeeDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val employeeName= view.findViewById<TextView>(R.id.textViewEmployeeName)
        val employeeSalary= view.findViewById<TextView>(R.id.textViewEmployeeSalary)
        val employeeAge= view.findViewById<TextView>(R.id.textViewEmployeeAge)

        fun bind(employee:Employee){
            employeeName.text=employee.employee_name
            employeeSalary.text=employee.employee_salary.toString()
            employeeAge.text=employee.employee_age.toString()
        }

    }

}