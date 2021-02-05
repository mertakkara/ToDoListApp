package com.rationalstudio.todolist.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem
import androidx.room.Room


@Database(
    entities = [TodoItem::class],
    version = 2
)

abstract class TodoDatabase: RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object {
        @Volatile
        private var instance: TodoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                TodoDatabase::class.java, "ToDoDB.db").build()
    }
}