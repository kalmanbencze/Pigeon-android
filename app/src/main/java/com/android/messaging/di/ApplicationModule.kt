package com.android.messaging.di

import android.app.Application
import android.content.Context
import com.android.messaging.data.ApplicationPreferences
import com.android.messaging.data.Preferences
import com.android.messaging.data.RunPreferences
import com.android.messaging.data.VersionPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule {

    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context {
        return application
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
}

