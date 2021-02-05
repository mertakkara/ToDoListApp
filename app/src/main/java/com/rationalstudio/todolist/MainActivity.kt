package com.rationalstudio.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rationalstudio.todolist.ui.todolist.ToDoViewModelFactory
import com.rationalstudio.todolist.ui.todolist.TodoViewModel
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
import com.rationalstudio.todolist.Data.Database.TodoDatabase
import androidx.lifecycle.ViewModelProviders
import com.rationalstudio.todolist.R
import androidx.lifecycle.Observer
import com.rationalstudio.todolist.Other.TodoItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.rationalstudio.todolist.ui.todolist.AddDialogListener
import com.rationalstudio.todolist.ui.todolist.AddTodoItemDialog
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database=TodoDatabase(this)
        val repository = ToDoRepository(database)
        val factory= ToDoViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(TodoViewModel::class.java)
        val adapter = TodoItemAdapter(listOf(), viewModel)

        rvTodoItems.layoutManager = LinearLayoutManager(this)
        rvTodoItems.adapter = adapter

        viewModel.getAllToDoItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddTodoItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: TodoItem) {
                        viewModel.insert(item)
                    }
                }).show()
        }

    }
}