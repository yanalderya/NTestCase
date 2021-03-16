package com.example.core.di.factory

import androidx.lifecycle.ViewModel
import com.example.core.base.viewmodel.BaseActivityViewModel
import com.example.core.di.scopes.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ActivityViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseActivityViewModel>, @JvmSuppressWildcards Provider<BaseActivityViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)