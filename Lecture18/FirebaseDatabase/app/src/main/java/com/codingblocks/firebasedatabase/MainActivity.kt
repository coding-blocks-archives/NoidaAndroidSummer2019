package com.codingblocks.firebasedatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        FirebaseDatabase.getInstance().reference
    }
    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var uid = auth.uid

        auth.addAuthStateListener {
            if (it.currentUser == null) {
                auth.signInWithEmailAndPassword("aggarwalpulkit@gmail.com", "12345678")
            } else {
                uid = it.uid ?: ""

                Toast.makeText(this, "${it.uid}", Toast.LENGTH_LONG).show()
            }
        }
//gDyWp8lMQOXix31SByWh8AqonkJ3

        val ref = db.child("messages/users/gDyWp8lMQOXix31SByWh8AqonkJ3")

        ref.addChildEventListener(object : ChildEventListener {
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
            ref.child(key!!).setValue(todo).addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }

    }
}

class Todo {
    var text: String = ""
    var time: String = ""
}
