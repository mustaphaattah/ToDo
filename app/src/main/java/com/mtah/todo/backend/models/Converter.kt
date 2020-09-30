package com.mtah.todo.backend.models

import androidx.room.TypeConverter
import com.mtah.todo.backend.models.Priority

class Converter {
    @TypeConverter
    fun priorityToString(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun stringToPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}