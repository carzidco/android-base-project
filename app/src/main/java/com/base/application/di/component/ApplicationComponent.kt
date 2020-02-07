package com.base.application.di.component

import com.base.application.App
import com.base.application.di.module.*
import com.base.application.di.module.DatabaseModule
import com.base.application.di.module.ViewBindingModule
import dagger.Component
import dagger.MembersInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    RepositoryModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    ViewBindingModule::class,
    ViewModelModule::class,
    RxModule::class
])
interface ApplicationComponent: MembersInjector<App>