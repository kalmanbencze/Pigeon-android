package com.android.messaging.di

import android.app.Application
import com.android.messaging.data.db.DataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kalman.bencze on 06/11/2017.
 */
@Module
class PersistenceModule {

    @Singleton
    @Provides
    internal fun provideDataBase(application: Application): DataBase {
        return DataBase.getInstance(application)
    }
}
