package com.mtah.todo.backend.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mtah.todo.backend.models.ToDo

@Dao
interface ToDoDao {

    @Insert
    suspend fun insert(toDo: ToDo): LiveData<List<ToDo>>

    @Delete
    suspend fun delete(toDo: ToDo): LiveData<List<ToDo>>

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll(): LiveData<List<ToDo>>

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAll(): LiveData<List<ToDo>>


}