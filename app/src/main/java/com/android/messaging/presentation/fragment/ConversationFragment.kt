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
import com.android.messaging.R
import com.android.messaging.data.model.Contact
import com.android.messaging.databinding.FragmentConversationBinding
import com.android.messaging.presentation.BaseFragment
import com.android.messaging.presentation.ConversationBindingAdapter
import com.android.messaging.presentation.databinding.DefaultBindingComponent
import com.android.messaging.presentation.databinding.OnMessageClickListener
import com.android.messaging.presentation.viewmodel.ConversationViewModel
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationFragment : BaseFragment() {

    companion object {
        const val TAG: String = "ConversationFragment"
        const val EXTRA_CONTACT_ID: String = "extraContactId"

        fun get(contact: Contact): ConversationFragment {
            val cf = ConversationFragment()
            cf.arguments = Bundle()
            cf.arguments?.putInt(EXTRA_CONTACT_ID, contact.id)
            return cf
        }
    }


    val itemListener = OnMessageClickListener()

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ConversationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(ConversationViewModel::class.java)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ConversationViewModel::class.java)

        itemListener.observe(this, Observer { contact ->
            Log.d(ContactsFragment.TAG, "onStart: " + contact)
            contact?.let { }
        })
    }

    private lateinit var adapter: ConversationBindingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentConversationBinding>(inflater, R.layout.fragment_conversation, null, false, DefaultBindingComponent()) as FragmentConversationBinding
        activity?.let {
            binding.viewModel = viewModel
            adapter = ConversationBindingAdapter(it, arguments!!.getInt(EXTRA_CONTACT_ID), itemListener)
            binding.messageList.adapter = adapter
            binding.messageList.layoutManager = LinearLayoutManager(activity)
            viewModel.start(arguments!!.getInt(EXTRA_CONTACT_ID))
            viewModel.messagesList.observe(this, Observer { list ->
                list?.let { data -> adapter.setData(data) }
            })
            viewModel.title.observe(this, Observer { title -> title?.let { data -> setActionBarTitle(data) } })
        }
        return binding.root
    }

    fun setActionBarTitle(title: String) {
        actionBar?.title = title
    }
}