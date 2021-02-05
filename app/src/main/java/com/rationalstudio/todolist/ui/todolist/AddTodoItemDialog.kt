package com.rationalstudio.todolist.ui.todolist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.rationalstudio.todolist.R
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem
import kotlinx.android.synthetic.main.dialog_add_todo_item.*
import com.rationalstudio.todolist.ui.todolist.AddDialogListener

class AddTodoItemDialog (context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_todo_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()

            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = TodoItem(name)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}