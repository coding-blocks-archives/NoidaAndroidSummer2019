package com.codingblocks.firebasedatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        FirebaseDatabase.getInstance().reference
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ref = db.child("messages/user1")

        db.child("messages")
            .child("user1")
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
                    tv.text = "${tv.text}  ${snapshot.getValue(Todo::class.java)?.text}"
                    //To get value of child key
                    // snapshot.key

                }

                override fun onChildRemoved(p0: DataSnapshot) {
                }

            })

        button.setOnClickListener {
            val todo = Todo()
            todo.text = editText.text.toString()
            todo.time = System.currentTimeMillis().toString()
            val key = ref.push().key
            ref.child(key!!).setValue(todo)
        }

    }
}

class Todo {
    var text: String = ""
    var time: String = ""
}
