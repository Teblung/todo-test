package com.example.todo.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import androidx.appcompat.widget.AppCompatTextView
import com.example.todo.R

class DialogUtils {
    companion object {
        fun alertDialogError(context: Context, e: Throwable) {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.error_view)
            val message = dialog.findViewById(R.id.tv_error_message) as AppCompatTextView
        }
    }
}