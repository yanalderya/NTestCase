package com.example.core.common.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun ImageView.loadUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun ImageView.loadUrl(url: Int) {
    Picasso.get()
        .load(url)
        .into(this)
}