package com.eshiett1995.todocompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eshiett1995.todocompose.data.dao.TaskDao
import com.eshiett1995.todocompose.data.entity.Task


@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao
}