package com.android.messaging

import android.databinding.DataBindingUtil
import com.android.messaging.di.DaggerAppComponent
import com.android.messaging.presentation.databinding.DefaultBindingComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class MessagingApplication : DaggerApplication(), HasActivityInjector, HasServiceInjector {

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        DataBindingUtil.setDefaultComponent(DefaultBindingComponent())
        LeakCanary.install(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

}