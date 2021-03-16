package com.example.ntestcase.ui.detail.ioc

import androidx.fragment.app.Fragment
import com.example.core.base.fragment.BaseViewModelFragmentModule
import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.common.util.Scheduler
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.di.keys.FragmentViewModelKey
import com.example.ntestcase.ui.detail.DetailFragment
import com.example.ntestcase.ui.detail.repository.DetailFragmentDataSource
import com.example.ntestcase.ui.detail.repository.DetailFragmentRepository
import com.example.ntestcase.ui.detail.viewmodel.DetailFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class DetailFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: DetailFragment): Fragment

    @Binds
    @IntoMap
    @FragmentViewModelKey(DetailFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(fragmentViewModel: DetailFragmentViewModel): BaseFragmentViewModel

    @Module
    companion object {

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideDetailLocalDataSource(mainDao: MainCardDao) = DetailFragmentDataSource(mainDao)

        @Provides
        @FragmentScope
        @JvmStatic
        fun provideDetailRepository(
            remote: DetailFragmentDataSource,
            scheduler: Scheduler,
            compositeDisposable: CompositeDisposable
        ) = DetailFragmentRepository(remote, scheduler, compositeDisposable)
    }
}