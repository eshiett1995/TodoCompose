package com.eshiett1995.todocompose.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddTaskViewModel : ViewModel() {
    var title : MutableLiveData<String> = MutableLiveData("")
    var detail : MutableLiveData<String> = MutableLiveData("")

    fun saveTask(){

    }
}