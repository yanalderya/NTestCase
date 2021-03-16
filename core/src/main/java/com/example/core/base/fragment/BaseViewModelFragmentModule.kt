package com.example.core.base.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.core.di.factory.FragmentViewModelFactory
import com.example.core.di.qualifiers.FragmentContext
import com.example.core.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseViewModelFragmentModule {

    @Binds
    @FragmentScope
    @FragmentContext
    abstract fun bindViewModelFactory(viewModelFactory: FragmentViewModelFactory): ViewModelProvider.Factory

    @Module
    companion object {
        @Provides
        @FragmentScope
        @FragmentContext
        @JvmStatic
        fun provideViewModelProvider(
            fragment: Fragment,
            @FragmentContext viewModelFactory: ViewModelProvider.Factory
        ): ViewModelProvider = ViewModelProviders.of(fragment, viewModelFactory)
    }
}