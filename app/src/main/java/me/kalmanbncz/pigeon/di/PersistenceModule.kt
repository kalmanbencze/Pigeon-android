package me.kalmanbncz.pigeon.di

import android.app.Application
import dagger.Module
import dagger.Provides
import me.kalmanbncz.pigeon.data.db.DataBase
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
