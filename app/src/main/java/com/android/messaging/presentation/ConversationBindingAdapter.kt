package com.android.messaging.presentation

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.messaging.R
import com.android.messaging.data.model.Message
import com.android.messaging.databinding.ItemMessageReceivedBinding
import com.android.messaging.databinding.ItemMessageSentBinding
import com.android.messaging.presentation.databinding.SingleLiveEvent

/**
 * Created by kalmanb on 9/6/17.
 */
class ConversationBindingAdapter(context: Context, val listener: SingleLiveEvent<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_SENT: Int = 0

    private val VIEW_TYPE_RECEIVED: Int = 1

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var data = ArrayList<Message>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_SENT) {
            val view = DataBindingUtil.inflate<ItemMessageSentBinding>(layoutInflater, R.layout.item_message_sent, parent, false)
            return SentViewHolder(view)
        } else {
            val view = DataBindingUtil.inflate<ItemMessageReceivedBinding>(layoutInflater, R.layout.item_message_received, parent, false)
            return ReceivedViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is SentViewHolder) {
            holder.bind(data.get(position), listener)
        } else if (holder is ReceivedViewHolder) {
            holder.bind(data.get(position), listener)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    companion object {
        val TAG = "ClickableBindingAdapter"
    }

    fun setData(data: List<Message>) {
        val result = DiffUtil.calculateDiff(MessageDiffCallback(this.data, data))
        this.data.clear();
        this.data.addAll(data);
        result.dispatchUpdatesTo(this);
    }
}

class MessageDiffCallback(val oldList: List<Message>, val newList: List<Message>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).id == newList.get(newItemPosition).id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList.get(newItemPosition).equals(oldList.get(oldItemPosition))
    }
}

class ReceivedViewHolder(var binding: ItemMessageReceivedBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(message: Message, listener: SingleLiveEvent<Message>) {
        binding.received = message
        binding.listener = listener
    }
}

class SentViewHolder(var binding: ItemMessageSentBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(message: Message, listener: SingleLiveEvent<Message>) {
        binding.sent = message
        binding.listener = listener
    }
}
