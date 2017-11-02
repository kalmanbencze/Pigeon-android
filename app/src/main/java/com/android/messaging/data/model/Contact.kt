package com.android.messaging.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Contact")
class Contact(
        @PrimaryKey(autoGenerate = true) var id: Int,
        var name: String,
        var photo: String,
        var number: String)