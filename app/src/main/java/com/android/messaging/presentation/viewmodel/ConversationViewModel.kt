package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.android.messaging.BR
import com.android.messaging.R
import com.android.messaging.data.model.Message
import com.android.messaging.data.repository.MessageRepository
import com.android.messaging.presentation.ConversationBindingAdapter
import com.android.messaging.presentation.ViewHolder
import com.android.messaging.presentation.databinding.OnMessageClickListener
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationViewModel @Inject
internal constructor(
        private val messageRepository: MessageRepository, private val owner: LifecycleOwner
) : ViewModel() {


    val messagesList: ObservableArrayList<Message> = ObservableArrayList<Message>()

    val itemListener = OnMessageClickListener()

    /**
     * Custom adapter that logs calls.
     */
    val adapter: ConversationBindingAdapter<Message> = ConversationBindingAdapter()

    val multipleItems = OnItemBindClass<Message>()
            .map(Message::class.java, BR.received, R.layout.item_message_received)
            .map(Message::class.java, BR.sent, R.layout.item_message_sent)

    /**
     * Custom view holders for RecyclerView
     */
    val viewHolder: BindingRecyclerViewAdapter.ViewHolderFactory = BindingRecyclerViewAdapter.ViewHolderFactory {
        ViewHolder(it.root)
    }


    fun start(contactId: Int) {
        messageRepository.getMessages(contactId).observe(owner, Observer {
            messagesList.clear()
            it.let {
                messagesList.clear()
                messagesList.addAll(it as List)
            }
        })
    }
}
