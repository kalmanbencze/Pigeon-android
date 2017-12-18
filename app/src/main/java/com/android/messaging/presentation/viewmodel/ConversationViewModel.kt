package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.android.messaging.data.model.Message
import com.android.messaging.data.repository.MessageRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationViewModel @Inject
internal constructor(
        private val messageRepository: MessageRepository, private val owner: LifecycleOwner
) : ViewModel() {

    val messagesList: ObservableArrayList<Message> = ObservableArrayList<Message>()

    fun start(contactId: Int) {
        messageRepository.getMessages(contactId).observe(owner, Observer {
            messagesList.clear()
            it.let {
                messagesList.clear()
                Collections.sort(it as List, { left, right -> (left.timestamp - right.timestamp).toInt() })
                messagesList.addAll(it)
            }
        })
    }
}
