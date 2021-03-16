package com.example.core.di.modules

import com.example.core.common.util.AppScheduler
import com.example.core.common.util.Scheduler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {

    @Provides
    @Singleton
    fun scheduler(): Scheduler {
        return AppScheduler()
    }
}