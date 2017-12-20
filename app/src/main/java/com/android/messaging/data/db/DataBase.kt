package com.android.messaging.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.android.messaging.data.model.Contact
import com.android.messaging.data.model.Message
import com.android.messaging.ioThread

/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Database(entities = arrayOf(Contact::class, Message::class), version = 1, exportSchema = true)
abstract class DataBase : RoomDatabase() {

    abstract fun contactDao(): ContactsDao
    abstract fun messagesDao(): MessagesDao

    companion object {

        @Volatile private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        DataBase::class.java, "Sample.db")
                        // prepopulate the database after onCreate was called
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).contactDao().insertAll(PREPOPULATE_CONTACTS)
                                    getInstance(context).messagesDao().insertAll(PREPOPULATE_MESSAGES)
                                }
                            }
                        })
                        .build()

        val PREPOPULATE_CONTACTS = listOf(
                Contact(1, "Tom", "", "0746421301"),
                Contact(2, "Jeff", "", "0785152654"),
                Contact(3, "Fred", "", "0785152654"),
                Contact(4, "Miriam", "", "0785152654"),
                Contact(5, "Vanessa", "", "0785152654"),
                Contact(6, "Ed", "", "0785152654")
        )

        val PREPOPULATE_MESSAGES = listOf(
                Message(1, 2, 1, "hello", System.currentTimeMillis()),
                Message(4, 1, 2, "hi", System.currentTimeMillis() + 1),
                Message(2, 2, 1, "whats up", System.currentTimeMillis() + 2),
                Message(5, 1, 2, "nothing, just chilling", System.currentTimeMillis() + 3),
                Message(3, 2, 1, "oh", System.currentTimeMillis() + 4),
                Message(6, 1, 2, "having a bud watching the game", System.currentTimeMillis() + 5)
        )
    }
}