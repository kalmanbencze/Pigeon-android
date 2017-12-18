package com.android.messaging.presentation.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.messaging.MainNavigator
import com.android.messaging.R
import com.android.messaging.data.model.Contact
import com.android.messaging.databinding.FragmentContactsBinding
import com.android.messaging.presentation.ContactBindingAdapter
import com.android.messaging.presentation.databinding.DefaultBindingComponent
import com.android.messaging.presentation.databinding.OnContactClickListener
import com.android.messaging.presentation.viewmodel.ContactsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by kalman.bencze on 02/11/2017.
 */
class ContactsFragment : DaggerFragment() {

    companion object {
        const val TAG: String = "ConversationFragment"
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    val itemListener = OnContactClickListener()

    private lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(ContactsViewModel::class.java)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ContactsViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        itemListener.observe(this, Observer { contact ->
            Log.d(TAG, "onStart: " + contact)
            contact?.let { openConversation(contact) }
        })

    }

    @Inject
    internal lateinit var navigator: MainNavigator

    private fun openConversation(contact: Contact) {
        navigator.openConversationScreen(contact)
    }

    private lateinit var adapter: ContactBindingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentContactsBinding>(inflater, R.layout.fragment_contacts, null, false, DefaultBindingComponent()) as FragmentContactsBinding
        binding.viewModel = viewModel
        activity?.let {
            adapter = ContactBindingAdapter(it, itemListener)
            binding.contactList.adapter = adapter
            binding.contactList.layoutManager = LinearLayoutManager(activity)
            viewModel.contactList.observe(this, Observer<List<Contact>> { list -> list?.let { data -> adapter.setData(data) } })
        }
        return binding.root
    }


}
