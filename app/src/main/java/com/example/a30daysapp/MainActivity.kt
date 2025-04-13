package com.example.a30daysapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val myDataset = Datasource.topics

        val recyclerView = findViewById<RecyclerView>(R.id.theory_list_recycler_view)

        recyclerView.adapter = TheoryTopicAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)

    }
}