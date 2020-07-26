package com.example.quizstudio.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizstudio.Adapters.BookAdapter
import com.example.quizstudio.Adapters.CustomAdater
import com.example.quizstudio.Adapters.LifeStyleAdapter
import com.example.quizstudio.Adapters.LifeTopicAdapter
import com.example.quizstudio.R
import com.example.quizstudio.models.itemModel
import com.example.quizstudio.models.subjectModel

class LifeStyle : AppCompatActivity() {
    private var arrayListLifeStyle=ArrayList<itemModel>()
    private var subjectListLifeStyle=ArrayList<subjectModel>()
    private val iconsNameLifeStyle = arrayOf("Knowing Me", "Friends", "World Flags", "Couple Love", "Entrepreneur", "Ladies Eyes", "History", "Expression", "Blogger Type", "Wine Likes", "People Likes", "Color Like", "Life Style","Music Like")
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView1: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_style)
        supportActionBar?.title="Select LifeStyle Quiz"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        recyclerView1=findViewById(R.id.horizental_recylerview_lifestyle)
        recyclerView2=findViewById(R.id.vertical_recylerview_lifestyle)
        arrayListLifeStyle= ArrayList()
        subjectListLifeStyle=ArrayList()
        subjectListLifeStyle.add(subjectModel("Knowing Me",R.drawable.meeting,"Who knows You"))
        subjectListLifeStyle.add(subjectModel("Friends Thinking",R.drawable.think,"Friends thinking about you"))
        subjectListLifeStyle.add(subjectModel("World Flags",R.drawable.pakistan,"Guess the Flag"))
        subjectListLifeStyle.add(subjectModel("Couple Love",R.drawable.love,"Who's Your Love"))
        subjectListLifeStyle.add(subjectModel("Entrepreneur",R.drawable.entrepreneur,"Are you Entrepreneur"))
        subjectListLifeStyle.add(subjectModel("Ladies Eyes",R.drawable.eye,"Eye Contact"))
        subjectListLifeStyle.add(subjectModel("History",R.drawable.history,"Your History Knowledge"))
        subjectListLifeStyle.add(subjectModel("People Likes",R.drawable.relationship,"What people Likes about You"))
        subjectListLifeStyle.add(subjectModel("Expression Read",R.drawable.feedback,"Facial Expression Read"))
        subjectListLifeStyle.add(subjectModel("Blogger Type",R.drawable.blog,"Are you Blogger"))
        subjectListLifeStyle.add(subjectModel("Wine Likes",R.drawable.alcohol,"Which Wine you Like"))
        subjectListLifeStyle.add(subjectModel("Color Like",R.drawable.feedback,"Your Color Choice"))
        subjectListLifeStyle.add(subjectModel("Life Style",R.drawable.relationship,"Your Life style"))
        subjectListLifeStyle.add(subjectModel("Music Like",R.drawable.love,"Your best Song"))

        recyclerView1.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.itemAnimator = DefaultItemAnimator()
        recyclerView2.layoutManager= GridLayoutManager(this,2)
        recyclerView2.itemAnimator= DefaultItemAnimator()

        for (element in iconsNameLifeStyle) {
            val itemModel = itemModel()
            itemModel.setName(element)

            //add in array list
            arrayListLifeStyle.add(itemModel)

            val adapter = LifeTopicAdapter(applicationContext, arrayListLifeStyle)
            recyclerView1.adapter = adapter
            val lifeAdapter= LifeStyleAdapter(applicationContext,subjectListLifeStyle)
            recyclerView2.adapter=lifeAdapter
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}