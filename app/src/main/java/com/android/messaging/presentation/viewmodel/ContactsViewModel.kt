package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.android.messaging.BR
import com.android.messaging.R
import com.android.messaging.data.model.Contact
import com.android.messaging.data.repository.ContactRepository
import com.android.messaging.presentation.BindingRecyclerAdapter
import com.android.messaging.presentation.ViewHolder
import com.android.messaging.presentation.databinding.OnContactClickListener
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ContactsViewModel @Inject
internal constructor(
        private val contactRepository: ContactRepository, private val owner: LifecycleOwner
) : ViewModel() {

    val contactList: ObservableArrayList<Contact> = ObservableArrayList<Contact>()

    val itemListener = OnContactClickListener()

    /**
     * Custom adapter that logs calls.
     */
    val adapter: BindingRecyclerAdapter<Contact> = BindingRecyclerAdapter(itemListener)

    val multipleItems = OnItemBindClass<Contact>()
            .map(Contact::class.java, BR.item, R.layout.item_contact)

    /**
     * Custom view holders for RecyclerView
     */
    val viewHolder: BindingRecyclerViewAdapter.ViewHolderFactory = BindingRecyclerViewAdapter.ViewHolderFactory {
        ViewHolder(it.root)
    }


    fun start() {
        contactRepository.getContacts().observe(owner, Observer {
            contactList.clear()
            it.let {
                contactList.clear()
                contactList.addAll(it as List)
            }
        })
    }
}