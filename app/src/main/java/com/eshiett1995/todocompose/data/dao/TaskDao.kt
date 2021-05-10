package com.eshiett1995.todocompose.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.eshiett1995.todocompose.data.entity.Task

@Dao
interface TaskDao {

    @Insert
    fun save(task : Task) : Task
}