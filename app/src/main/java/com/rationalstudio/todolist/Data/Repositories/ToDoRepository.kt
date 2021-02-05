package com.rationalstudio.todolist.Data.Repositories

import com.rationalstudio.todolist.Data.Database.TodoDatabase
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem

class ToDoRepository (
    private val db: TodoDatabase
) {
    suspend fun insert(item: TodoItem) = db.getTodoDao().insert(item)

    suspend fun delete(item: TodoItem) = db.getTodoDao().delete(item)

    fun getAllToDoItems() = db.getTodoDao().getAllToDoItems()
}