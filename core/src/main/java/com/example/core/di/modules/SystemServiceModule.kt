package com.example.core.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.core.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
object SystemServiceModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    @JvmStatic
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()
}