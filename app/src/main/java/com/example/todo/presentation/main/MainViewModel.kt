package com.example.todo.presentation.main

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import com.example.todo.CreateTodoSealed
import com.example.todo.ListTodoSealed
import com.example.todo.domain.TodoService
import com.example.todo.model.Todo
import com.example.todo.utils.DateUtils
import com.google.android.gms.maps.model.LatLng
import java.util.*


class MainViewModel(
    private val todoService: TodoService,
    private val dateUtils: DateUtils
) : ViewModel() {

    private val calendar = Calendar.getInstance()

    private val mTodoCacheLiveData: MutableLiveData<ListTodoSealed> = MutableLiveData()
    val observerList get() = mTodoCacheLiveData

    private val mTodoState: MutableLiveData<CreateTodoSealed> = MutableLiveData()
    val observerSave get() = mTodoState

    private val mTitleLiveData: MutableLiveData<String> = MutableLiveData()
    val observerTitle get() = mTitleLiveData

    private val mDescriptionLiveData: MutableLiveData<String> = MutableLiveData()
    val observerDescription get() = mDescriptionLiveData

    private val mDateLiveData: MutableLiveData<String> = MutableLiveData()
    val observerDate get() = mDateLiveData

    private val mLatLngLiveData: MutableLiveData<LatLng> = MutableLiveData()
    val observerLatLng get() = mLatLngLiveData

    fun getTodoList() {
        mTodoCacheLiveData.value = ListTodoSealed.Progress
        observerList.asFlow()
    }

    fun getTodoById(id: Int) {
        mTodoState.value = CreateTodoSealed.OnProgressGet
        observerTitle.asFlow()
        observerDescription.asFlow()
        observerDate.asFlow()
        observerLatLng.asFlow()
    }

    private fun saveTodo(todo: Todo) {
        mTodoState.value = CreateTodoSealed.OnProgressSave
    }

    fun getCalender(view: View) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(view.context, { _, _, _, _ ->

        }, year, month, day)
        dpd.show()
        getHours(view.context, calendar)
    }

    private fun getHours(context: Context, calendar: Calendar) {
        val tpd = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)
        }
        TimePickerDialog(context, tpd, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
    }

    fun submit(todo: Todo) {
        saveTodo(todo)
    }
}