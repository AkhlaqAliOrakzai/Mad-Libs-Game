package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class Story : AppCompatActivity() {
    var cstory = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        var intent = getIntent()
        var story = intent.getStringExtra("story")
        var storyView = findViewById<TextView>(R.id.textView6)
        storyView.text = story
        cstory = story.toString()


    }
    fun makeAnotherStoryClick(view: View){
        var intent = Intent(this, Input_Your_Words :: class.java)
        startActivity(intent)
    }
}