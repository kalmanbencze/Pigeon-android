package com.android.messaging.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.android.messaging.data.model.Contact
import com.android.messaging.ioThread

/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Database(entities = arrayOf(Contact::class), version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun contactDao(): ContactsDao

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
                                    getInstance(context).contactDao().insertAll(PREPOPULATE_DATA)
                                }
                            }
                        })
                        .build()

        val PREPOPULATE_DATA = listOf(
                Contact(1, "val", "", "0746421301"),
                Contact(2, "val 2", "", "0785152654"),
                Contact(3, "val 2", "", "0785152654"),
                Contact(4, "val 2", "", "0785152654"),
                Contact(5, "val 2", "", "0785152654"),
                Contact(6, "val 2", "", "0785152654")
        )
    }
}