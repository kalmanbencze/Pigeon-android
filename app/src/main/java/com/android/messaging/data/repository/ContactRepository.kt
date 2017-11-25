package com.android.messaging.data.repository

import android.arch.lifecycle.LiveData
import com.android.messaging.data.model.Contact

/**
 * Created by kalman.bencze on 02/11/2017.
 */
interface ContactRepository {
    fun getContacts(): LiveData<List<Contact>>
    fun getContact(id: Int): LiveData<Contact>
}