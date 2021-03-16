package com.example.core.base.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.di.qualifiers.FragmentContext
import javax.inject.Inject

abstract class BaseDataFetchFragment<VM : BaseFragmentViewModel> : BaseFragment() {

    @Inject
    @field:FragmentContext
    protected lateinit var viewModelProvider: ViewModelProvider

    protected abstract val viewModelClass: Class<VM>

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider.get(viewModelClass)
    }
}