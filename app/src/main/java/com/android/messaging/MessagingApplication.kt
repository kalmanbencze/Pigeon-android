package com.android.messaging

import android.app.Activity
import android.app.Application
import android.app.Service
import android.databinding.DataBindingUtil
import com.android.messaging.presentation.databinding.DefaultBindingComponent
import com.android.messaging.di.AppInjector
import com.squareup.leakcanary.LeakCanary
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class MessagingApplication : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    internal lateinit var serviceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        AppInjector.init(this)
        DataBindingUtil.setDefaultComponent(DefaultBindingComponent())
        LeakCanary.install(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service> {
        return serviceInjector
    }
}