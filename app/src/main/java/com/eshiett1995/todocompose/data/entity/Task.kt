package com.eshiett1995.todocompose.data

import androidx.lifecycle.ViewModel
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Task(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "detail") val detail : String
)