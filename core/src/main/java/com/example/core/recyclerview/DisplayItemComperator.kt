package com.example.core.recyclerview

interface DisplayItemComperator {
    fun areItemsSame(oldItem: DisplayItem, newItem: DisplayItem): Boolean

    fun areContentsSame(oldItem: DisplayItem, newItem: DisplayItem): Boolean
}
