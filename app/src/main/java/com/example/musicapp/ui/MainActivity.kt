package com.example.musicapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.R
import com.example.musicapp.adapter.ParentAdapter
import com.example.musicapp.model.ParentItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        parent_recycler.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ParentItem>()

        for (i in 1..3) {
            data.add(ParentItem("Playlists for you"))
            data.add(ParentItem("Trending Playlist"))
            data.add(ParentItem("Stations for You"))
        }


        val adapter = ParentAdapter(data, this)
        parent_recycler.adapter = adapter
    }
}