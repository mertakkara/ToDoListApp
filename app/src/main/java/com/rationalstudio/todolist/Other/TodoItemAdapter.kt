package com.rationalstudio.todolist.Other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rationalstudio.todolist.R
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem
import com.rationalstudio.todolist.ui.todolist.TodoViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoItemAdapter (
    var items: List<TodoItem>,
    private val viewModel: TodoViewModel
): RecyclerView.Adapter<TodoItemAdapter.ToDoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val curTodoItem = items[position]

        holder.itemView.tvName.text = curTodoItem.name

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curTodoItem)
        }




    }

    inner class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}