package me.kalmanbncz.pigeon.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import me.kalmanbncz.pigeon.data.model.Contact
import me.kalmanbncz.pigeon.data.repository.ContactRepository
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ContactsViewModel @Inject
internal constructor(
        contactRepository: ContactRepository
) : ViewModel() {

    val contactList: LiveData<List<Contact>> = contactRepository.getContacts()

}