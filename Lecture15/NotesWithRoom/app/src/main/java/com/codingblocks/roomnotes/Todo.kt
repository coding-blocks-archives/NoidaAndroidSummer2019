package com.codingblocks.roomnotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
//    @ColumnInfo(name = "What needs to be done")
    val task: String,
    val status: Boolean
)