package com.example.ntestcase.ui.add.ioc

import androidx.fragment.app.Fragment
import com.example.core.base.fragment.BaseViewModelFragmentModule
import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.common.util.Scheduler
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.di.keys.FragmentViewModelKey
import com.example.ntestcase.ui.add.AddFragment
import com.example.ntestcase.ui.add.repository.AddFragmentDataSource
import com.example.ntestcase.ui.add.repository.AddFragmentRepository
import com.example.ntestcase.ui.add.viewmodel.AddFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class AddFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: AddFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(AddFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(fragmentViewModel: AddFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMainLocalDataSource(mainDao: MainCardDao) = AddFragmentDataSource(mainDao)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideMainRepository(
            remote: AddFragmentDataSource,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = AddFragmentRepository(remote, scheduler, compositeDisposable)
    }
}