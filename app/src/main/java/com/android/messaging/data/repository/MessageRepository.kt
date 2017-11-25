package com.android.messaging.data.repository

import android.arch.lifecycle.LiveData
import com.android.messaging.data.model.Message

/**
 * Created by kalman.bencze on 02/11/2017.
 */
interface MessageRepository {
    fun getMessages(contactId: Int): LiveData<List<Message>>
}