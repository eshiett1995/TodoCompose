package com.eshiett1995.todocompose.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.eshiett1995.todocompose.data.AppDatabase
import com.eshiett1995.todocompose.data.entity.Task

class ViewTasksViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application
    var tasks : LiveData<List<Task>> = AppDatabase.getAppDatabase(context)?.taskDao()!!.getAll()
}