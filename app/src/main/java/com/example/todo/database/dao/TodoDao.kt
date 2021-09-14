package com.example.todo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.model.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTodo(todo: Todo): Long

    @Query("SELECT * FROM todo where id = :id")
    fun getTodoById(id: Int): Todo

    @Query("SELECT * FROM todo")
    fun getListTodo(): List<Todo>
}