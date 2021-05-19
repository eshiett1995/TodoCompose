package com.eshiett1995.todocompose.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eshiett1995.todocompose.data.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): LiveData<List<Task>>

    @Insert
    suspend fun insertAll(vararg task: Task)
}