package me.kalmanbncz.pigeon.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import me.kalmanbncz.pigeon.data.model.Contact
import org.intellij.lang.annotations.Language


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

    @Language("RoomSql")
    @Query("SELECT * FROM Contacts WHERE id = :contactId")
    fun getContact(contactId: Int): LiveData<Contact>

    @Language("RoomSql")
    @Query("SELECT * FROM Contacts ORDER BY id ASC")
    fun loadContacts(): LiveData<List<Contact>>

    @Language("RoomSql")
    @Query("SELECT name FROM Contacts WHERE id = :contactId")
    fun getContactName(contactId: Int): LiveData<String>
}
