package com.android.messaging.presentation

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.messaging.R
import com.android.messaging.data.model.Contact
import com.android.messaging.databinding.ItemContactBinding
import com.android.messaging.presentation.databinding.SingleLiveEvent

/**
 * Created by kalmanb on 9/6/17.
 */
class ContactBindingAdapter(context: Context, val listener: SingleLiveEvent<Contact>) : RecyclerView.Adapter<ViewHolder>() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var data = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = DataBindingUtil.inflate<ItemContactBinding>(layoutInflater, R.layout.item_contact, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(data.get(position), listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<Contact>) {
        val result = DiffUtil.calculateDiff(ContactDiffCallback(this.data, data))
        this.data.clear();
        this.data.addAll(data);
        result.dispatchUpdatesTo(this);
    }
}


class ContactDiffCallback(val oldList: List<Contact>, val newList: List<Contact>) : DiffUtil.Callback() {

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

class ViewHolder(var binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Contact, listener: SingleLiveEvent<Contact>) {
        binding.item = contact
        binding.listener = listener
    }
}

