package com.rationalstudio.todolist.Data.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rationalstudio.todolist.Data.Database.Entities.TodoItem


@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: TodoItem)

    @Delete
    suspend fun delete(item: TodoItem)

    @Query("SELECT * FROM todo_items")
    fun getAllToDoItems(): LiveData<List<TodoItem>>
}