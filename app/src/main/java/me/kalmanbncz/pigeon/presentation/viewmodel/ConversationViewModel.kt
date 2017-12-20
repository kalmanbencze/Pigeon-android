package me.kalmanbncz.pigeon.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import me.kalmanbncz.pigeon.data.model.Message
import me.kalmanbncz.pigeon.data.repository.ContactRepository
import me.kalmanbncz.pigeon.data.repository.MessageRepository
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationViewModel @Inject
internal constructor(
        private val messageRepository: MessageRepository,
        private val contactRepository: ContactRepository
) : ViewModel() {

    lateinit var messagesList: LiveData<List<Message>>
    lateinit var title: LiveData<String>

    fun start(contactId: Int) {
        messagesList = messageRepository.getMessages(contactId)
        title = contactRepository.getContactName(contactId)
    }
}
