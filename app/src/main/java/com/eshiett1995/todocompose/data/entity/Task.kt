package com.eshiett1995.todocompose.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "detail") val detail : String,
    @ColumnInfo(name = "completed") val completed : Boolean
)