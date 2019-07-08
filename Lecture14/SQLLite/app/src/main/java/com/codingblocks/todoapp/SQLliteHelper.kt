package com.codingblocks.todoapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLliteHelper(context: Context) : SQLiteOpenHelper(context, "task.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TasksTable.CMD_CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}