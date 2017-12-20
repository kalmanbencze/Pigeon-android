package me.kalmanbncz.pigeon.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Contacts")
class Contact(
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "photo")
        var photo: String,
        @ColumnInfo(name = "number")
        var number: String)