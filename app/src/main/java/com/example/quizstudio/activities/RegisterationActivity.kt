package com.example.quizstudio.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.quizstudio.MainActivity
import com.example.quizstudio.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.android.synthetic.main.activity_registeration.*

@Suppress("CAST_NEVER_SUCCEEDS")
class RegisterationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    private lateinit var emailEt: TextInputEditText
    private lateinit var passwordEt: TextInputEditText
    private lateinit var usernameEt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)
        supportActionBar!!.title="Sign Up"
        auth = FirebaseAuth.getInstance()
        emailEt = findViewById(R.id.signup_email)
        passwordEt = findViewById(R.id.signup_Password)
        usernameEt = findViewById(R.id.signup_username)
        progressBar=findViewById(R.id.progress_bar)
        sigUp_relative.setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }

        register.setOnClickListener {
            var email:String=emailEt.text.toString()
            var password:String=passwordEt.text.toString()
            var username:String =usernameEt.text.toString()
            if (TextUtils.isEmpty(username))
            {
                usernameEt.error="Enter Your Name"
            } else if(TextUtils.isEmpty(email)){
                emailEt.error = "Enter Your Email"
            }
            else if(TextUtils.isEmpty(password) ){
                passwordEt.error="Enter Your Password"
            }

            else {
                progressBar.visibility=View.VISIBLE
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener{ task ->
                        if(task.isSuccessful){
                            progressBar.visibility=View.GONE
                            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                            val intent = Intent(this,CategorySelection::class.java)
                            startActivity(intent)
                            finish()
                        }else {
                            if (task.exception is FirebaseAuthUserCollisionException) {
                                Toast.makeText(this, "You are already Registered", Toast.LENGTH_LONG).show()
                                progressBar.visibility=View.GONE
                            } else
                            {

                               Toast.makeText(this,task.exception!!.message,Toast.LENGTH_LONG).show()

                            }
                        }
                    })
            }
            SelectGender()
        }
       

    }

    private fun SelectGender() {

    }


}