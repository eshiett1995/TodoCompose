package com.eshiett1995.todocompose.viewModels
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.eshiett1995.todocompose.data.AppDatabase
import com.eshiett1995.todocompose.data.dao.TaskDao
import com.eshiett1995.todocompose.data.entity.Task

class AddTaskViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    var title : MutableLiveData<String> = MutableLiveData("")
    var detail : MutableLiveData<String> = MutableLiveData("")

    fun saveTask(){
        val task = Task(id = 0, title = title.value!!, detail = detail.value!! )
        val taskDao : TaskDao? = AppDatabase.getAppDatabase(context)?.taskDao()
        taskDao!!.save(task)
    }

    fun changeTitle(text: String){
        title.value = text
    }

    fun changeDetail(text: String){
        detail.value = text
    }
}