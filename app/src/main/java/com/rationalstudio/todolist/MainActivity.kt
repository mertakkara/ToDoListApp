package com.rationalstudio.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rationalstudio.todolist.ui.todolist.ToDoViewModelFactory
import com.rationalstudio.todolist.ui.todolist.TodoViewModel
import com.rationalstudio.todolist.Data.Repositories.ToDoRepository
import com.rationalstudio.todolist.Data.Database.TodoDatabase
import androidx.lifecycle.ViewModelProvider
import com.rationalstudio.todolist.R
import androidx.lifecycle.Observer
import com.rationalstudio.todolist.Other.TodoItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.rationalstudio.todolist.ui.todolist.AddDialogListener
import com.rationalstudio.todolist.ui.todolist.AddTodoItemDialog
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: ToDoViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this,factory).get(TodoViewModel::class.java)
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