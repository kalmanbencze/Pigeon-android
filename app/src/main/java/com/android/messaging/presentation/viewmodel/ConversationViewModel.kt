package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.android.messaging.data.model.Message
import com.android.messaging.data.repository.MessageRepository
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationViewModel @Inject
internal constructor(
        private val messageRepository: MessageRepository, private val owner: LifecycleOwner
) : ViewModel() {

    lateinit var messagesList: LiveData<List<Message>>

    fun start(contactId: Int) {
        messagesList = messageRepository.getMessages(contactId)
    }
}
