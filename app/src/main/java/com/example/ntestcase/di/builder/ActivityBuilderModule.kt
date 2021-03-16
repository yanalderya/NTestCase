package com.example.ntestcase.di.builder

import com.example.core.di.scopes.ActivityScope
import com.example.ntestcase.ui.main.MainActivity
import com.example.ntestcase.ui.main.ioc.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}