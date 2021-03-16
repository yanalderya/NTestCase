package com.example.ntestcase.application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<NesineApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance

        fun application(app: NesineApp): Builder

        fun build(): ApplicationComponent
    }
}