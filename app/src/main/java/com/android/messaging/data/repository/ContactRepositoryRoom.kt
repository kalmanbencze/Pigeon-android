package com.android.messaging.data.repository

import android.arch.lifecycle.LiveData
import com.android.messaging.AppExecutors
import com.android.messaging.data.db.DataBase
import com.android.messaging.data.model.Contact
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by kalman.bencze on 06/11/2017.
 */
@Singleton
class ContactRepositoryRoom
@Inject
constructor(private val appExecutors: AppExecutors, private val db: DataBase) : ContactRepository {

    override fun getContacts(): LiveData<List<Contact>> {
        return db.contactDao().loadContacts()
    }
}

