package com.codingblocks.roomnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(this,
            AppDatabase::class.java,
            "todo.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.todoDao().getAllTask()
    }
}
