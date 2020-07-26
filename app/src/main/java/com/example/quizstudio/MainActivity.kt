package com.example.quizstudio

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizstudio.Adapters.BookAdapter
import com.example.quizstudio.Adapters.CustomAdater
import com.example.quizstudio.models.itemModel
import com.example.quizstudio.models.subjectModel


class MainActivity : AppCompatActivity() {
    private var arrayList=ArrayList<itemModel>()
    private var subjectList=ArrayList<subjectModel>()
    private val iconsName = arrayOf("Chemistry", "Physics", "Computer", "Biology", "Math", "General", "History", "Technology", "Art & Science", "Geography", "Islamic", "English", "Software")


    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title="Choose Learning Subject"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        recyclerView=findViewById(R.id.horizental_recylerview)
        recyclerView2=findViewById(R.id.vertical_recylerview)
        arrayList = ArrayList()
        subjectList=ArrayList()
        subjectList.add(subjectModel("Chemistry",R.drawable.chemistry,"Power of Chemicals"))
        subjectList.add(subjectModel("Physics",R.drawable.physics,"Physics is the best"))
        subjectList.add(subjectModel("Computer",R.drawable.cs,"Computer have Fun"))
        subjectList.add(subjectModel("Biology",R.drawable.bio,"Bio is Perfect"))
        subjectList.add(subjectModel("Math",R.drawable.math,"Check your Math Ability"))
        subjectList.add(subjectModel("General",R.drawable.generl,"Your General Knowledge"))
        subjectList.add(subjectModel("History",R.drawable.history,"Have you History Knowledge"))
        subjectList.add(subjectModel("Technology",R.drawable.tech,"Fun with Technology"))
        subjectList.add(subjectModel("Art & Science",R.drawable.art,"Art and Science"))
        subjectList.add(subjectModel("Geography",R.drawable.geography,"Have your Area knowledge"))
        subjectList.add(subjectModel("Islamic",R.drawable.islamic,"You Must learn Islamic "))
        subjectList.add(subjectModel("English",R.drawable.english,"Check you English Grammar"))
        subjectList.add(subjectModel("Software",R.drawable.software,"Who many software you know"))
        subjectList.add(subjectModel("world",R.drawable.globe,"Your Global knowledge"))


        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView2.layoutManager=GridLayoutManager(this,2)
        recyclerView2.itemAnimator=DefaultItemAnimator()



        for (element in iconsName) {
            val itemModel = itemModel()
            itemModel.setName(element)

            //add in array list
            arrayList.add(itemModel)
        }



        // adapter setting
        val adapter = CustomAdater(applicationContext, arrayList)
        recyclerView.adapter = adapter
        val bookAdapter=BookAdapter(applicationContext,subjectList)
        recyclerView2.adapter=bookAdapter

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

}