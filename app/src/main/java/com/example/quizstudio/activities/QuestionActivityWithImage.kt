package com.example.quizstudio.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.quizstudio.R
import kotlinx.android.synthetic.main.activity_question_with_image.*
import kotlinx.android.synthetic.main.activity_question_without_image.*

class QuestionActivityWithImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_with_image)

        if (intent!=null)
        {
            val type: String? =intent.getStringExtra("type")
            tv_bookname_style_text.text=type

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