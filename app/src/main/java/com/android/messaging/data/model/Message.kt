package com.android.messaging.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Kali on 11/25/2017.
 */

@Entity(tableName = "Messages",
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = Contact::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("senderId")),
                ForeignKey(
                        entity = Contact::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("receiverId"))
        ))
class Message(
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "senderId", index = true)
        var senderId: Int,
        @ColumnInfo(name = "receiverId", index = true)
        var receiverId: Int,
        @ColumnInfo(name = "content")
        var content: String,
        @ColumnInfo(name = "timestamp")
        var timestamp: Long)