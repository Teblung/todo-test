package com.example.todo.domain.impl

import com.example.todo.RequestSealed
import com.example.todo.data.todo.TodoRepository
import com.example.todo.domain.cases.GetListUsesCase
import com.example.todo.utils.DateUtils

class GetListImpl(
        private val dateUtils: DateUtils,
        private val todoRepository: TodoRepository
) : GetListUsesCase {
    override suspend fun invoke(): RequestSealed {
        TODO("Buatlah logic untuk mendapatkan list todo." +
                "Code dibuat berdasarkan unit test yang telah disediakan")
    }
}