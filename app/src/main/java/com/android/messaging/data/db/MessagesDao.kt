package com.android.messaging.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.android.messaging.data.model.Message
import org.intellij.lang.annotations.Language


/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Dao
interface MessagesDao {
    @get:Query("SELECT * FROM Messages")
    val all: List<Message>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(messages: List<Message>)

    @Language("RoomSql")
    @Query("SELECT * FROM Messages WHERE receiverId = :contactId OR senderId = :contactId ORDER BY timestamp ASC")
    fun loadMessages(contactId: Int): LiveData<List<Message>>
}
