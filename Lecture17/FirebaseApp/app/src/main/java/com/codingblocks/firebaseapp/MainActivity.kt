package com.codingblocks.firebaseapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }
    var verificationId:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        auth.addAuthStateListener {
//            if (it.currentUser != null) {
//                btn.isVisible = false
//                btn2.isVisible = true
//            } else {
//                btn.isVisible = true
//                btn2.isVisible = false
//            }
//        }

        btn2.setOnClickListener {
//            auth.signOut()
            val phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId,password.editText?.text.toString())
                createAccount(phoneAuthCredential)
        }

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                Toast.makeText(this@MainActivity, "Verification Completed", Toast.LENGTH_LONG).show()
                createAccount(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                Toast.makeText(this@MainActivity, "Verification Failed", Toast.LENGTH_LONG).show()

            }

            override fun onCodeSent(p0: String?, p1: PhoneAuthProvider.ForceResendingToken?) {
                super.onCodeSent(p0, p1)
                Toast.makeText(this@MainActivity, "Code Sent", Toast.LENGTH_LONG).show()
                verificationId = p0!!
            }

        }
        btn.setOnClickListener {
            //            if (email.editText?.text.isNullOrEmpty()) {
//                email.isErrorEnabled = true
//                email.error = "Cannot be Empty"
//            } else if (password.editText?.text.isNullOrEmpty()) {
//                password.isErrorEnabled = true
//                password.error = "Cannot be Empty"
//            } else {
//                auth.createUserWithEmailAndPassword(
//                    email.editText?.text.toString(),
//                    password.editText?.text.toString()
//                ).addOnCompleteListener {
//                    btn.isEnabled = false
//                }.addOnSuccessListener {
//                    btn.isEnabled = true
//                    Toast.makeText(this, "Account Created Succesfully", Toast.LENGTH_LONG).show()
//
//                }.addOnFailureListener {
//                    btn.isEnabled = true
//                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//                    if (it.localizedMessage.contains("use", true)) {
//                        loginUser()
//                    }
//                }
//            }

            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91${email.editText?.text}", // Phone number to verify
                60, // Timeout duration
                TimeUnit.SECONDS, // Unit of timeout
                this, // Activity (for callback binding)
                callbacks
            ) // OnVerificationStateChangedCallbacks
        }

    }

    private fun createAccount(p0: PhoneAuthCredential?) {
        auth.signInWithCredential(p0!!).addOnCompleteListener {

        }.addOnSuccessListener {

        }.addOnFailureListener {

        }

    }

    private fun loginUser() {
        auth.signInWithEmailAndPassword(
            email.editText?.text.toString(),
            password.editText?.text.toString()
        ).addOnCompleteListener {
            btn.isEnabled = false
        }.addOnSuccessListener {
            btn.isEnabled = true
            Toast.makeText(this, "Logged In Succesfully", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            btn.isEnabled = true
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}
