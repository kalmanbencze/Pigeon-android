package com.android.messaging.data.db;

import java.util.List;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.android.messaging.data.model.Contact;

/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Dao
public interface ContactsDao {
    @Query("SELECT * FROM Contact")
    List<Contact> getAll();

    @Insert
    void insertAll(Contact contacts);

    @Delete
    void delete(Contact contact);

    @Query("SELECT * FROM Contact "
            + "WHERE id = :contactId")
    List<Contact> getContact(int contactId);
}
