package com.codingblocks.roomnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "todo.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    var list = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = db.todoDao().getAllTask().filter { todo ->
            todo.task.contains("abc", true)
        } as ArrayList<Todo>
        val adapter = TaskAdapter(list)
        lvTodolist.adapter = adapter
        adapter.listItemClickListener = object : ListItemClickListener {
            override fun lisitemClick(task: Todo, position: Int) {
                db.todoDao().deleteTask(task)
                list = db.todoDao().getAllTask() as ArrayList<Todo>
                adapter.updateTasks(list)
            }

        }

        btnAdd.setOnClickListener {
            db.todoDao().insertRow(
                Todo(
                    task = etNewItem.text.toString(),
                    status = false
                )
            )
            list = db.todoDao().getAllTask() as ArrayList<Todo>
            adapter.updateTasks(list)
        }


    }
}
