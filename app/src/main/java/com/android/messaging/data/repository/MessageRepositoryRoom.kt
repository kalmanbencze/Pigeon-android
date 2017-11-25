package com.android.messaging.data.repository

import android.arch.lifecycle.LiveData
import com.android.messaging.AppExecutors
import com.android.messaging.data.db.DataBase
import com.android.messaging.data.model.Message
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


