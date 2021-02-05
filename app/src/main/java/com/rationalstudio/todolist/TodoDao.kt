package com.rationalstudio.todolist

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rationalstudio.todolist.TodoItem


@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: TodoItem)

    @Delete
    suspend fun delete(item: TodoItem)

    @Query("SELECT * FROM todo_items")
    fun getAllToDoItems(): LiveData<List<TodoItem>>
}