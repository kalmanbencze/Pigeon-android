package me.kalmanbncz.pigeon.data.repository

import android.arch.lifecycle.LiveData
import me.kalmanbncz.pigeon.data.model.Contact

/**
 * Created by kalman.bencze on 02/11/2017.
 */
interface ContactRepository {
    fun getContacts(): LiveData<List<Contact>>
    fun getContact(id: Int): LiveData<Contact>
    fun getContactName(contactId: Int): LiveData<String>
}