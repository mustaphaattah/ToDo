package com.mtah.todo.backend

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mtah.todo.backend.models.ToDo
import com.mtah.todo.backend.persistence.ToDoDatabase
import com.mtah.todo.backend.persistence.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel (application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository

    private val allToDos: LiveData<List<ToDo>>

    init {
        repository = ToDoRepository(toDoDao)
        allToDos = repository.allToDos
    }

    fun insert(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO) {
            repository.insert(toDo)
    }


    fun delete(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO) {
            repository.delete(toDo)
    }

    fun getAll(): LiveData<List<ToDo>> {
        return repository.allToDos
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

}