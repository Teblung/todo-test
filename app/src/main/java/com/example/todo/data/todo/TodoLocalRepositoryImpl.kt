package com.example.todo.data.todo

import com.example.todo.database.dao.TodoDao
import com.example.todo.model.Todo

class TodoLocalRepositoryImpl(private val todoDao: TodoDao) : TodoRepository {
    override suspend fun saveTodo(todo: Todo): Long = todoDao.saveTodo(todo)

    override suspend fun getTodoById(id: Int): Todo = todoDao.getTodoById(id)

    override suspend fun getListTodo(): List<Todo> = todoDao.getListTodo()
}