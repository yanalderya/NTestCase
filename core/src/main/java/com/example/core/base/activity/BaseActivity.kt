package com.example.core.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.core.base.viewmodel.BaseActivityViewModel
import com.example.core.di.qualifiers.ActivityContext
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<VM : BaseActivityViewModel> : AppCompatActivity(),
    HasSupportFragmentInjector {

    @Inject
    protected lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @get:LayoutRes

    protected abstract val layoutViewRes: Int

    @Inject
    @field:ActivityContext
    protected lateinit var viewModelProvider: ViewModelProvider

    protected abstract val viewModelClass: Class<VM>

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutViewRes)
        viewModel = viewModelProvider.get(viewModelClass)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
    }
}