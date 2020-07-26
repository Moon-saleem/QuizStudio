package com.example.quizstudio.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizstudio.MainActivity
import com.example.quizstudio.R
import kotlinx.android.synthetic.main.activity_category_selection.*

class CategorySelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)
        supportActionBar?.title="Select Quiz Category"
        edu_card.setOnClickListener {
            val eduIntent=Intent(this,MainActivity::class.java)
            startActivity(eduIntent)
        }
        life_card.setOnClickListener {
            val lifeIntent=Intent(this,LifeStyle::class.java)
            startActivity(lifeIntent)
        }
    }
}