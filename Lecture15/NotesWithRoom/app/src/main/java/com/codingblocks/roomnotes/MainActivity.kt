package com.codingblocks.roomnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
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

    var formData: MediatorLiveData<Boolean> = MediatorLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = TaskAdapter(list)

        //Return Value in Synchronous manner
//        db.todoDao().getAllTask().value
        //Return value in Async Manner
        formData.addSource(db.todoDao().getAllTask()) {
            if (it.isNotEmpty()) {
                formData.value = false
            } else {
                formData.value = true
                formData.removeSource(db.todoDao().getAllTask())
            }
        }

        db.todoDao().getAllTask().observe(this, Observer {
            list = it.filter { todo ->
                todo.task.contains("abc", true)
            } as ArrayList<Todo>
            adapter.updateTasks(list)

        })
//        list = db.todoDao().getAllTask().filter { todo ->
//            todo.task.contains("abc", true)
//        } as ArrayList<Todo>
        lvTodolist.adapter = adapter
        adapter.listItemClickListener = object : ListItemClickListener {
            override fun lisitemClick(task: Todo, position: Int) {
                db.todoDao().deleteTask(task)
            }

        }

        btnAdd.setOnClickListener {
            db.todoDao().insertRow(
                Todo(
                    task = etNewItem.text.toString(),
                    status = false
                )
            )
        }


    }
}
