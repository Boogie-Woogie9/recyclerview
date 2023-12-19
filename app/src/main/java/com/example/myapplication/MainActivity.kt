package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder


data class Note(val number: Int, val text:String, val url: String)

class MainActivity : AppCompatActivity() {

    private lateinit var notes: List<Note>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recycler)
        val resultString = application.assets
            .open("notes.json")
            .bufferedReader()
            .use { it.readText() }
        val gson = GsonBuilder().create()
        notes = gson.fromJson(resultString,Array<Note>::class.java).toList()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter(notes)

    }
}