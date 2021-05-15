package com.eshiett1995.todocompose.viewModels
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshiett1995.todocompose.data.AppDatabase

class AddTaskViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    var title : MutableLiveData<String> = MutableLiveData("")
    var detail : MutableLiveData<String> = MutableLiveData("")

    fun saveTask(){
        AppDatabase.getAppDatabase(context)?.taskDao()
    }
}