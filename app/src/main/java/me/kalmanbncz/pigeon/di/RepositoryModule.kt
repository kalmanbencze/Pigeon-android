package me.kalmanbncz.pigeon.di

import dagger.Module
import dagger.Provides
import me.kalmanbncz.pigeon.AppExecutors
import me.kalmanbncz.pigeon.data.db.DataBase
import me.kalmanbncz.pigeon.data.repository.ContactRepository
import me.kalmanbncz.pigeon.data.repository.ContactRepositoryRoom
import me.kalmanbncz.pigeon.data.repository.MessageRepository
import me.kalmanbncz.pigeon.data.repository.MessageRepositoryRoom

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
