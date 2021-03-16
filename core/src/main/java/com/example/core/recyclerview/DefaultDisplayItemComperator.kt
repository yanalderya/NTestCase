package com.example.core.recyclerview

class DefaultDisplayItemComperator : DisplayItemComperator {

    override fun areItemsSame(oldItem: DisplayItem, newItem: DisplayItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsSame(oldItem: DisplayItem, newItem: DisplayItem): Boolean {
        return oldItem == newItem
    }

}
