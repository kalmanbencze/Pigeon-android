package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import com.android.messaging.data.ContactsProvider
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ContactsViewModel @Inject
internal constructor(
        val contactsProvider: ContactsProvider
) : ViewModel() {
    fun start() {
        contactsProvider.getContacts()
    }
}