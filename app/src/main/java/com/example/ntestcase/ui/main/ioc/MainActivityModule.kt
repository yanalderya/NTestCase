package com.example.ntestcase.ui.main.ioc

import androidx.appcompat.app.AppCompatActivity
import com.example.core.base.activity.BaseActivityModule
import com.example.core.base.viewmodel.BaseActivityViewModel
import com.example.core.di.scopes.ActivityScope
import com.example.ntestcase.di.builder.FragmentBuilderModule
import com.example.ntestcase.di.keys.ActivityViewModelKey
import com.example.ntestcase.ui.main.MainActivity
import com.example.ntestcase.ui.main.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        BaseActivityModule::class,
        FragmentBuilderModule::class
    ]
)
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(activityViewModel: MainActivityViewModel): BaseActivityViewModel
}