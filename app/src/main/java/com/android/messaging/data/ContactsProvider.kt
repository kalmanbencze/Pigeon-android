package com.android.messaging.data

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.android.messaging.data.model.Contact

/**
 * Created by kalman.bencze on 02/11/2017.
 */
interface ContactsProvider {
    fun getContacts(): LiveData<PagedList<Contact>>
}