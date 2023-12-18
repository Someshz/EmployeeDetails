package com.example.employeedetails.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {


    abstract fun getDao(): EmployeeDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null;
        fun getDatabase(context: Context): EmployeeDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDatabase::class.java,
                        "EmployeeInfoDatabase"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}