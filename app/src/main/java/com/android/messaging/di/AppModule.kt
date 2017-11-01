package com.android.messaging.di

import android.app.Application
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ProcessLifecycleOwner
import com.android.messaging.data.ApplicationPreferences
import com.android.messaging.data.Preferences
import com.android.messaging.data.RunPreferences
import com.android.messaging.data.VersionPreferences
import com.android.messaging.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kalman.bencze on 01/11/2017.
 */
@Module(includes = arrayOf(ViewModelModule::class))
internal class AppModule {

    @Provides
    fun provideLifeCycleOwner(): LifecycleOwner {
        return ProcessLifecycleOwner.get()
    }

    @Singleton
    @Provides
    fun provideApplicationPreferences(application: Application): ApplicationPreferences {
        return ApplicationPreferences(application)
    }

    @Singleton
    @Provides
    fun providePreferences(appPrefs: ApplicationPreferences): Preferences {
        return Preferences(appPrefs)
    }

    @Singleton
    @Provides
    fun provideRunPreferences(prefs: Preferences): RunPreferences {
        return prefs
    }

    @Singleton
    @Provides
    fun provideVersionPreferences(prefs: Preferences): VersionPreferences {
        return prefs
    }

    companion object {

        private val TAG = "AppModule"
    }
}

