package com.example.ntestcase.ui.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.navigateUp
import com.example.core.base.activity.BaseActivity
import com.example.ntestcase.R
import com.example.ntestcase.ui.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val layoutViewRes = R.layout.activity_main

    override val viewModelClass = MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.detailFragment, R.id.addFragment, R.id.navigation_main))

        setupActionBarWithNavController(navController, appBarConfiguration)

        toolbar.setupWithNavController(navController, appBarConfiguration)

        toolbar.setNavigationOnClickListener {
            navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        }
    }
}