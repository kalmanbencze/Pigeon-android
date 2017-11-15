package com.android.messaging.di

import android.app.Application
import com.android.messaging.MessagingApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        PersistenceModule::class,
        RepositoryModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: MessagingApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
