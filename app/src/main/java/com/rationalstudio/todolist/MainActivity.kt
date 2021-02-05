package com.rationalstudio.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rationalstudio.todolist.ui.todolist.ToDoViewModelFactory
import com.rationalstudio.todolist.ui.todolist.TodoViewModel
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
import com.rationalstudio.todolist.Data.Database.TodoDatabase
import androidx.lifecycle.ViewModelProviders
import com.rationalstudio.todolist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database=TodoDatabase(this)
        val repository = ToDoRepository(database)
        val factory= ToDoViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(TodoViewModel::class.java)
        //sa

    }
}