package com.rationalstudio.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
//sasa

@Suppress("UNCHECKED_CAST")
class ToDoViewModelFactory (
    private val repository: ToDoRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}