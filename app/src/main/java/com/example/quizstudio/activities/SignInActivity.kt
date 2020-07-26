package com.example.quizstudio.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizstudio.MainActivity
import com.example.quizstudio.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var signinemailEt: TextInputEditText
    private lateinit var signinpasswordEt: TextInputEditText
    private lateinit var forgotPasswordTv: TextView
    private lateinit var loginProgressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.title="Sign In"
        signinemailEt=findViewById(R.id.signIn_email)
        signinpasswordEt=findViewById(R.id.signIn_Password)
        forgotPasswordTv=findViewById(R.id.forgot_password)
        loginProgressBar=findViewById(R.id.progress_bar)
        auth = FirebaseAuth.getInstance()

       //hide soft input keyboard
        relative_layout.setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
             imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }

        signIn.setOnClickListener {
            var email:String=signinemailEt.text.toString()
            var password:String=signinpasswordEt.text.toString()
           if(TextUtils.isEmpty(email)){
                signinemailEt.error = "Enter Your Email"
            }
            else if(TextUtils.isEmpty(password)){
                signinpasswordEt.error="Enter Your Password"
            }
            else {
               loginProgressBar.visibility= View.VISIBLE
               auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener{ task ->
                   loginProgressBar.visibility=View.GONE
                if(task.isSuccessful){
                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                    val intent = Intent(this,CategorySelection::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    finish()
                }else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                }
            })
            }
        }
        Register_now.setOnClickListener {
            val intent = Intent(this, RegisterationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}