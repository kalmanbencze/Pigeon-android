package me.kalmanbncz.pigeon.data.repository

import android.arch.lifecycle.LiveData
import me.kalmanbncz.pigeon.AppExecutors
import me.kalmanbncz.pigeon.data.db.DataBase
import me.kalmanbncz.pigeon.data.model.Contact
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by kalman.bencze on 06/11/2017.
 */
@Singleton
class ContactRepositoryRoom
@Inject
constructor(private val appExecutors: AppExecutors, private val db: DataBase) : ContactRepository {
    override fun getContactName(contactId: Int): LiveData<String> {
        return db.contactDao().getContactName(contactId)
    }

    override fun getContact(id: Int): LiveData<Contact> {
        return db.contactDao().getContact(id)
    }

    override fun getContacts(): LiveData<List<Contact>> {
        return db.contactDao().loadContacts()
    }
}


