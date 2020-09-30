package com.mtah.todo.backend.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDo (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var priority: Priority,
    var title: String,
    var description: String
)