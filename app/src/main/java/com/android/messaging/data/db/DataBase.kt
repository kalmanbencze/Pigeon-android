package com.android.messaging.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.android.messaging.data.model.Contact

/**
 * Created by kalman.bencze on 02/11/2017.
 */
@Database(entities = arrayOf(Contact::class), version = 0)
abstract class DataBase : RoomDatabase() {

    abstract fun contactDao(): ContactsDao
}