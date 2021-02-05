package com.rationalstudio.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: ToDoRepository
) : ViewModel() {

    fun upsert(item: TodoItem) =
        GlobalScope.launch {
            repository.insert(item)
        }

    fun delete(item: TodoItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllToDoItems() = repository.getAllToDoItems()

}