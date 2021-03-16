package com.example.ntestcase.ui.main.ioc

import androidx.fragment.app.Fragment
import com.example.core.base.fragment.BaseViewModelFragmentModule
import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.common.util.Scheduler
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.di.keys.FragmentViewModelKey
import com.example.ntestcase.ui.main.MainFragment
import com.example.ntestcase.ui.main.repository.MainLocalDataSource
import com.example.ntestcase.ui.main.repository.MainRepository
import com.example.ntestcase.ui.main.viewmodel.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class MainFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(MainFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(fragmentViewModel: MainFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMainLocalDataSource(mainDao: MainCardDao) = MainLocalDataSource(mainDao)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMainRepository(
            remote: MainLocalDataSource,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = MainRepository(remote, scheduler, compositeDisposable)
    }
}