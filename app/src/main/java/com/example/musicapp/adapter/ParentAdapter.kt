package com.example.musicapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.R
import com.example.musicapp.model.ChildItem
import com.example.musicapp.model.ParentItem
import kotlinx.android.synthetic.main.parent_item_layout.view.*

class ParentAdapter(private val pList: List<ParentItem>, private val context: Context):
RecyclerView.Adapter<ParentAdapter.ParentViewHolder>(){

    class ParentViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParentAdapter.ParentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_item_layout, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentAdapter.ParentViewHolder, position: Int) {
        val data=pList[position]

        val imageList=ArrayList<ChildItem>()
       when(position){

          0 -> {
              imageList.add(ChildItem(R.drawable.music16))
              imageList.add(ChildItem(R.drawable.music17))
              imageList.add(ChildItem(R.drawable.music18))
              imageList.add(ChildItem(R.drawable.music19))
              imageList.add(ChildItem(R.drawable.music20))
              imageList.add(ChildItem(R.drawable.music1))
              imageList.add(ChildItem(R.drawable.music2))
              imageList.add(ChildItem(R.drawable.music3))
              imageList.add(ChildItem(R.drawable.music4))
              imageList.add(ChildItem(R.drawable.musicplayer))


          }
           1->{
               imageList.add(ChildItem(R.drawable.music6))
               imageList.add(ChildItem(R.drawable.music7))
               imageList.add(ChildItem(R.drawable.music8))
               imageList.add(ChildItem(R.drawable.music9))
               imageList.add(ChildItem(R.drawable.music10))
               imageList.add(ChildItem(R.drawable.music20))
               imageList.add(ChildItem(R.drawable.music21))
               imageList.add(ChildItem(R.drawable.music22))
               imageList.add(ChildItem(R.drawable.music23))
               imageList.add(ChildItem(R.drawable.music24))
           }
           2-> {
               imageList.add(ChildItem(R.drawable.music11))
               imageList.add(ChildItem(R.drawable.music12))
               imageList.add(ChildItem(R.drawable.music13))
               imageList.add(ChildItem(R.drawable.music14))
               imageList.add(ChildItem(R.drawable.music15))
               imageList.add(ChildItem(R.drawable.music25))
               imageList.add(ChildItem(R.drawable.music11))
               imageList.add(ChildItem(R.drawable.music18))
               imageList.add(ChildItem(R.drawable.music19))
               imageList.add(ChildItem(R.drawable.music20))


           }
        }
        holder.itemView.child_recycler.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        val adapter= ChildAdapter(imageList,context)
        holder.itemView.child_recycler.adapter=adapter

    }

    override fun getItemCount(): Int {
       return 3
    }

}