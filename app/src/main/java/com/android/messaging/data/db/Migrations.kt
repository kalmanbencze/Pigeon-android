package com.android.messaging.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import android.support.annotation.NonNull

/**
 * Created by kalman.bencze on 18/12/2017.
 */

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(@NonNull database: SupportSQLiteDatabase) {

    }
}