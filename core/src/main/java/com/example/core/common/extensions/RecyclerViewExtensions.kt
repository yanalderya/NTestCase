package com.example.core.common.extensions

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.recyclerview.RecyclerViewAdapter

@SuppressLint("WrongConstant")
fun RecyclerView.setup(
    adapter: RecyclerViewAdapter,
    layoutManager: LinearLayoutManager = LinearLayoutManager(this.context),
    isHasFixedSize: Boolean = false
) {
    this.layoutManager = layoutManager
    this.setHasFixedSize(isHasFixedSize)
    adapter?.let {
        this.adapter = adapter
    }
}
