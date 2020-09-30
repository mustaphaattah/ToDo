package com.mtah.todo.backend.persistence

import android.content.Context
import androidx.room.*
import com.mtah.todo.backend.models.Converter
import com.mtah.todo.backend.models.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {

        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}