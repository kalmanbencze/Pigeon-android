package com.android.messaging.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.android.messaging.data.model.Contact


/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Dao
interface ContactsDao {
    @get:Query("SELECT * FROM Contacts")
    val all: List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contacts: List<Contact>)

    @Delete
    fun delete(contact: Contact)

    @Query("SELECT * FROM Contacts " + "WHERE id = :contactId")
    fun getContact(contactId: Int): LiveData<Contact>


//    @Query("SELECT * FROM Contact")
//    abstract fun loadContacts(): LivePagedListProvider<Int, Contact>


//
//    fun load(): LiveData<List<Contact>> {
//        val order = SparseIntArray()
//        var index = 0
//        return Transformations.map<List<Contact>, List<Contact>>(loadContacts()) { repositories ->
//            Collections.sort(repositories, { r1, r2 ->
//                val pos1 = order.get(r1.id)
//                val pos2 = order.get(r2.id)
//                pos1 - pos2
//            })
//            repositories
//        }
//    }

    @Query("SELECT * FROM Contacts")
    fun loadContacts(): LiveData<List<Contact>>
}
