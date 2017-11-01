package com.android.messaging.di

import android.app.Application
import android.content.Context
import com.android.messaging.MessagingApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by kalmanb on 9/21/17.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBindingModule::class, ServiceBindingModule::class))
interface AppComponent {

    fun inject(app: MessagingApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(application: Context): Builder

        fun build(): AppComponent
    }
}
