package com.example.todo.domain.impl

import com.example.todo.RequestSealed
import com.example.todo.data.todo.TodoRepository
import com.example.todo.domain.cases.GetTodoByIdUsesCase
import com.example.todo.model.Todo
import com.example.todo.utils.DateUtils

class GetTodoByIdImpl(
    private val dateUtils: DateUtils,
    private val todoLocalRepository: TodoRepository
) : GetTodoByIdUsesCase {

    override suspend fun invoke(id: Int): RequestSealed {
        TODO("Buatlah logic untuk mengambil data todo by id." +
                "Code dibuat berdasarkan unit test yang telah disediakan")
    }
}