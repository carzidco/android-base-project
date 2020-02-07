package com.base.application.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
internal class RxModule {

    @Provides
    @Named("mainScheduler")
    fun provideMainScheduler() : Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Named("ioScheduler")
    fun provideIOScheduler() : Scheduler {
        return Schedulers.io()
    }
}