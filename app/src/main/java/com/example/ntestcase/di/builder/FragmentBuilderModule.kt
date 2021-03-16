package com.example.ntestcase.di.builder

import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.ui.add.AddFragment
import com.example.ntestcase.ui.add.ioc.AddFragmentModule
import com.example.ntestcase.ui.detail.DetailFragment
import com.example.ntestcase.ui.detail.ioc.DetailFragmentModule
import com.example.ntestcase.ui.main.MainFragment
import com.example.ntestcase.ui.main.ioc.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AddFragmentModule::class])
    abstract fun contributeAddFragment(): AddFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun contributeDetailFragment(): DetailFragment
}