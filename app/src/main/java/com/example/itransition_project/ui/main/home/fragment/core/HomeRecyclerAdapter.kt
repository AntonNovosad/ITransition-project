package com.example.itransition_project.ui.main.home.fragment.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itransition_project.R
import com.example.ui.home.model.HomeDataUi


class HomeRecyclerAdapter :
    RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>() {

    private var list: List<HomeDataUi> = emptyList()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextText: TextView = itemView.findViewById(R.id.textViewText)
        val homeImageView: ImageView = itemView.findViewById(R.id.homeImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val home = list[position]
        holder.largeTextText.text = home.text
        Glide.with(holder.itemView).load(home.image)
            .into(holder.homeImageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(list: List<HomeDataUi>) {
        this.list = list
        notifyDataSetChanged()
    }
}