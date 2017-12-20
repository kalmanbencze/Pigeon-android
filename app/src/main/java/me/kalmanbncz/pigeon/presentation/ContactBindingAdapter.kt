package me.kalmanbncz.pigeon.presentation

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.kalmanbncz.pigeon.R
import me.kalmanbncz.pigeon.data.model.Contact
import me.kalmanbncz.pigeon.databinding.ItemContactBinding
import me.kalmanbncz.pigeon.presentation.databinding.SingleLiveEvent

/**
 * Created by kalmanb on 9/6/17.
 */
class ContactBindingAdapter(context: Context, val listener: SingleLiveEvent<Contact>) : RecyclerView.Adapter<ContactViewHolder>() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var data = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactViewHolder {
        val view = DataBindingUtil.inflate<ItemContactBinding>(layoutInflater, R.layout.item_contact, parent, false)
        return ContactViewHolder(view)

    }

    override fun onBindViewHolder(holder: ContactViewHolder?, position: Int) {
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

class ContactViewHolder(var binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Contact, listener: SingleLiveEvent<Contact>) {
        binding.item = contact
        binding.listener = listener
    }
}

