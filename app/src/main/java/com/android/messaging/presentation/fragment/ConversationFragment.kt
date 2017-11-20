package com.android.messaging.presentation.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.android.messaging.data.model.Contact
import com.android.messaging.presentation.viewmodel.ConversationViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationFragment : DaggerFragment() {

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

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ConversationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(ConversationViewModel::class.java)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ConversationViewModel::class.java)
    }

}