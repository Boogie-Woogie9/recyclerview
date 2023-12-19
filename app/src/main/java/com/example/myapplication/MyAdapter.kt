package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Note>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val fname: TextView = view.findViewById(R.id.firstname)
        val lname: TextView = view.findViewById(R.id.lastName)
        val url: ImageView = view.findViewById(R.id.icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.fname.text = list[position].number.toString()
        holder.lname.text = list[position].text
        Picasso.get().load(list[position].url).into(holder.url);
    }
}