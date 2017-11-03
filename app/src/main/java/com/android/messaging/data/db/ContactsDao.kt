package com.android.messaging.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.messaging.data.model.Contact

/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Dao
interface ContactsDao {
    @get:Query("SELECT * FROM Contact")
    val all: List<Contact>

    @Insert
    fun insertAll(contacts: Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("SELECT * FROM Contact " + "WHERE id = :contactId")
    fun getContact(contactId: Int): List<Contact>
}
