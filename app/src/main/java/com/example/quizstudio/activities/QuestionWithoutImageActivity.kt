package com.example.quizstudio.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.quizstudio.R
import kotlinx.android.synthetic.main.activity_question_without_image.*

class QuestionWithoutImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_question_without_image)
//        supportActionBar?.hide()

        if (intent!=null)
        {
            val type: String? =intent.getStringExtra("type")
            tv_bookname.text=type

        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}