package com.example.itransition_project.ui.main.home.fragment.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itransition_project.R
import com.example.ui.home.model.HomeDataUi


class HomeRecyclerAdapter :
    RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>() {

    private var list: List<HomeDataUi> = emptyList()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextText: TextView = itemView.findViewById(R.id.textViewText)
        val smallTextImage: TextView = itemView.findViewById(R.id.textViewImage)
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
        holder.smallTextImage.text = home.image
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(list: List<HomeDataUi>) {
        this.list = list
        notifyDataSetChanged()
    }
}