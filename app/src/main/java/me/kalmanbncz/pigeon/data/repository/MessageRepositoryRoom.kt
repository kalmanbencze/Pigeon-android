package me.kalmanbncz.pigeon.data.repository

import android.arch.lifecycle.LiveData
import me.kalmanbncz.pigeon.AppExecutors
import me.kalmanbncz.pigeon.data.db.DataBase
import me.kalmanbncz.pigeon.data.model.Message
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by kalman.bencze on 06/11/2017.
 */
@Singleton
class MessageRepositoryRoom
@Inject
constructor(private val appExecutors: AppExecutors, private val db: DataBase) : MessageRepository {

    override fun getMessages(contactId: Int): LiveData<List<Message>> {
        return db.messagesDao().loadMessages(contactId)
    }
}


