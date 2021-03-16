package com.example.core.common.util

import io.reactivex.Scheduler

interface Scheduler {
    fun mainThread(): Scheduler
    fun io(): Scheduler
}