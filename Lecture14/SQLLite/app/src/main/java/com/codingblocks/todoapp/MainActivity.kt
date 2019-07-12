package com.codingblocks.todoapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.btnAdd
import kotlinx.android.synthetic.main.activity_main.etNewItem
import kotlinx.android.synthetic.main.activity_main.lvTodolist

class MainActivity : AppCompatActivity() {

    var tasks = arrayListOf<Task>()
    val buttonClicked: MutableLiveData<Boolean> = MutableLiveData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonClicked.value = true

        buttonClicked.observe(this, Observer {
            if (it) {
                Toast.makeText(this@MainActivity, "Live data exampe", Toast.LENGTH_LONG).show()
            }
        })

        val dbHelper = SQLliteHelper(this)
        val taskDb = dbHelper.writableDatabase

        tasks = TasksTable.getAllTask(taskDb)

        val taskAdapter = TaskAdapter(tasks)
        lvTodolist.adapter = taskAdapter

        btnAdd.setOnClickListener {
            buttonClicked.value = !buttonClicked.value!!
            TasksTable.insertTask(
                taskDb, Task(null, etNewItem.text.toString(), true)
            )
            taskAdapter.updateTasks(TasksTable.getAllTask(taskDb))
        }
//        val arrayAdapter = ArrayAdapter<Task>(this,android.R.layout.simple_list_item_1)
//         arrayAdapter.notifyDataSetChanged()

        lvTodolist.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                tasks.removeAt(position)
                taskAdapter.notifyDataSetChanged()

            }
    }

    class TaskAdapter(var tasks: ArrayList<Task>) : BaseAdapter() {

        fun updateTasks(newTasks: ArrayList<Task>) {
            tasks.clear()
            tasks.addAll(newTasks)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val li =
                parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = li.inflate(android.R.layout.simple_list_item_1, parent, false)
            view.findViewById<TextView>(android.R.id.text1).text = getItem(position).task

            return view
        }

        override fun getItem(position: Int): Task = tasks[position]

        override fun getItemId(position: Int): Long = 0

        override fun getCount(): Int = tasks.size

    }
}
