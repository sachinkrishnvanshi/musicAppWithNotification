package com.example.musicapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.ui.MusicActivity
import com.example.musicapp.R
import com.example.musicapp.model.ChildItem
import kotlinx.android.synthetic.main.child_item_layout.view.*

class ChildAdapter(private val list : List<ChildItem>,val context: Context) :
RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildAdapter.ViewHolder, position: Int) {
        val data=list[position]
        holder.itemView.iv_music_load.setImageResource(data.image)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"I am listening this song", Toast.LENGTH_SHORT).show()
           val intent= Intent(context, MusicActivity::class.java)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size

    }
}