package com.example.core.di.factory

import androidx.lifecycle.ViewModel
import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.di.scopes.FragmentScope
import javax.inject.Inject
import javax.inject.Provider

@FragmentScope
class FragmentViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseFragmentViewModel>, @JvmSuppressWildcards Provider<BaseFragmentViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)