package ru.itis.summerpractice24.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    text: String,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar.make(this, text, duration).show()
}
