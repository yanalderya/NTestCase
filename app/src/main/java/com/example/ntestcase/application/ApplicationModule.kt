package com.example.ntestcase.application

import android.app.Application
import android.content.Context
import com.example.core.di.modules.SystemServiceModule
import com.example.core.di.modules.UtilModule
import com.example.core.di.qualifiers.ApplicationContext
import com.example.ntestcase.di.builder.ActivityBuilderModule
import com.example.ntestcase.di.modules.DataModule
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        UtilModule::class,
        SystemServiceModule::class,
        DataModule::class,
        ActivityBuilderModule::class
    ]
)
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun bindApplication(app: NesineApp): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}