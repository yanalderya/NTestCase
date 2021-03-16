package com.example.core.base.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.core.di.factory.ActivityViewModelFactory
import com.example.core.di.qualifiers.ActivityContext
import com.example.core.di.scopes.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindActivityContext(@ActivityContext activity: AppCompatActivity): Context

    @Binds
    @ActivityScope
    abstract fun bindViewModelFactory(viewModelFactory: ActivityViewModelFactory): ViewModelProvider.Factory

    @Module
    companion object {

        @Provides
        @ActivityScope
        @ActivityContext
        @JvmStatic
        fun provideViewModelProvider(
            activity: AppCompatActivity,
            viewModelFactory: ViewModelProvider.Factory
        ): ViewModelProvider = ViewModelProviders.of(activity, viewModelFactory)
    }
}