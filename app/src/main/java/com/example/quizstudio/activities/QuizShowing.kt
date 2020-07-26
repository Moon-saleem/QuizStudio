package com.example.quizstudio.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.quizstudio.R
import kotlinx.android.synthetic.main.activity_quiz_showing.*

class QuizShowing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_showing)

        if (intent!=null)
        {
            var type: String? =intent.getStringExtra("type")
            textView.text = type
        }
        supportActionBar?.title=textView.text
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}