package com.android.messaging.di

import com.android.messaging.AppExecutors
import com.android.messaging.data.db.DataBase
import com.android.messaging.data.repository.ContactRepository
import com.android.messaging.data.repository.ContactRepositoryRoom
import com.android.messaging.data.repository.MessageRepository
import com.android.messaging.data.repository.MessageRepositoryRoom
import dagger.Module
import dagger.Provides

/**
 * Created by kalman.bencze on 06/11/2017.
 */
@Module
class RepositoryModule {

    @Provides
    internal fun provideContactRepository(executors: AppExecutors, db: DataBase): ContactRepository {
        return ContactRepositoryRoom(executors, db)
    }

    @Provides
    internal fun provideMessageRepository(executors: AppExecutors, db: DataBase): MessageRepository {
        return MessageRepositoryRoom(executors, db)
    }

}
