package com.example.core.common.extensions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.transact(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

inline fun FragmentManager.transact(stackName: String, func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func()
        .addToBackStack(stackName)
        .commit()
}