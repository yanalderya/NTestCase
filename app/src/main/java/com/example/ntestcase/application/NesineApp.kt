package com.example.ntestcase.application

import dagger.android.support.DaggerApplication

open class NesineApp : DaggerApplication() {

    private val applicationInjector = DaggerApplicationComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector

}