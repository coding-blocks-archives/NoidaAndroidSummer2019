package com.codingblocks.firebaseapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            if (email.editText?.text.isNullOrEmpty()) {
                email.isErrorEnabled = true
                email.error = "Cannot be Empty"
            } else if (password.editText?.text.isNullOrEmpty()) {
                password.isErrorEnabled = true
                password.error = "Cannot be Empty"
            } else {
                auth.createUserWithEmailAndPassword(
                    email.editText?.text.toString(),
                    password.editText?.text.toString()
                ).addOnCompleteListener {
                    btn.isEnabled = false
                }.addOnSuccessListener {
                    btn.isEnabled = true
                    Toast.makeText(this, "Account Created Succesfully", Toast.LENGTH_LONG).show()

                }.addOnFailureListener {
                    btn.isEnabled = true
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
