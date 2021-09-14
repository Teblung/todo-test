package com.example.todo.domain.impl

import com.example.todo.RequestSealed
import com.example.todo.data.todo.TodoRepository
import com.example.todo.domain.cases.SaveTodoUsesCase
import com.example.todo.model.Todo
import com.example.todo.utils.DateUtils

class SaveTodoImpl(
    private val dateUtils: DateUtils,
    private val todoLocalRepository: TodoRepository
) : SaveTodoUsesCase {


    override suspend fun invoke(todo: Todo): RequestSealed {
        TODO(
            "Buatlah logic untuk melakukan save todo," +
                    "Code dibuat berdasarkan unit test yang telah disediakan."
        )
    }
}