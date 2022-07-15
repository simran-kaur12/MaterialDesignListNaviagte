package com.example.a13julytask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val list: ArrayList<Value>, private val listener: OnItemClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_data,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listData = list[position]
        holder.name.text = listData.UserNum
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name : TextView = itemView.findViewById(R.id.num)
        init{
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}