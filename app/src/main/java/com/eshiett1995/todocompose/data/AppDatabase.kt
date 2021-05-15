package com.eshiett1995.todocompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.eshiett1995.todocompose.data.dao.TaskDao
import com.eshiett1995.todocompose.data.entity.Task
import androidx.room.Room

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao
    companion object{
        var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task-database"
                )
                .allowMainThreadQueries()
                .build()
            }
            return INSTANCE
        }
    }
}