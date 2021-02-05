package com.rationalstudio.todolist.ui.todolist

import com.rationalstudio.todolist.Data.Database.Entities.TodoItem

interface AddDialogListener {
    fun onAddButtonClicked(item: TodoItem)
}