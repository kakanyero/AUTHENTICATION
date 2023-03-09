package com.example.authenticate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassword : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        auth = Firebase.auth
    }
    fun Send (view: View){
        val emailet =findViewById<EditText>(R.id.emailet11)
        if (TextUtils.isEmpty(emailet.toString())){
            Toast.makeText(this,"Please enter your email",Toast.LENGTH_LONG).show()
        }else{
            auth.sendPasswordResetEmail(emailet.text.toString()).addOnCompleteListener{task->
                if (task.isSuccessful){
                    Toast.makeText(this,"Reset link sent to your email",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Un able to send reset email",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}