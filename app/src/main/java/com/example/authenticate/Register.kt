package com.example.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
    }
    //View is the base class for widgets
    fun register (view: View){
        val email = findViewById<EditText>(R.id.etemail1)
        val password = findViewById<EditText>(R.id.etpwd2)
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener {
                task ->
            if (task.isSuccessful){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    fun goToLogin(view: View){
        val intent =Intent(this,Login::class.java)
        startActivity(intent)
    }
}