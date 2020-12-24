package com.example.christmasmemorygame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SelectGameAdapter(private val onItemCLick: onItemCLick) :
    ListAdapter<String, SelectGameAdapter.viewHolder>(DiffCall()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_game_list_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class viewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                onItemCLick.onGameClick(currentList[adapterPosition])
            }
        }

        val textView =view.findViewById<TextView>(R.id.gameName)
        fun bind(data: String) {
            textView.text=data
        }
    }

    class DiffCall : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem:String
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem:String ,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }

}
interface onItemCLick{
    fun onGameClick(game:String)
}