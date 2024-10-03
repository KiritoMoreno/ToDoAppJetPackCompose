package com.example.todoapp.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class TasksViewModel @Inject constructor():ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _tasks = mutableStateListOf<TaskModel>()
    val task:List<TaskModel> =_tasks

    fun onDialogClose(){
        _showDialog.value = false

    }
    fun onTasksCreated(task:String){
        _showDialog.value = false
        _tasks.add(TaskModel(task= task))
    }
    fun onShowDialogClick(){
        _showDialog.value = true
    }
    fun onCheckBoxSelected(taskModel: TaskModel){
        val index = _tasks.indexOf(taskModel)
        if (index != -1){
            _tasks[index] = taskModel.copy(selected = !taskModel.selected)
        }
    }
    fun onItemRemove(taskModel: TaskModel) {
        val task = _tasks.find { it.id == taskModel.id }
        _tasks.remove(task)
    }
}