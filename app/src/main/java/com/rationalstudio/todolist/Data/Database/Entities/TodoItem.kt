package com.rationalstudio.todolist.Data.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_items")
data class TodoItem(
    @ColumnInfo(name = "item_name")
    var name: String
)  {
    @PrimaryKey(autoGenerate = true)
    var kid: Int? = null
}