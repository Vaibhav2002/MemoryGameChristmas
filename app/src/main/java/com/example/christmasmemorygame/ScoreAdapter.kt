package com.example.christmasmemorygame

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.christmasmemorygame.local.PrevScore

class ScoreAdapter() :
    ListAdapter<PrevScore, ScoreAdapter.viewHolder>(DiffCall()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.prev_score_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class viewHolder(val view: View) :

        RecyclerView.ViewHolder(view) {
        val scoreText=view.findViewById<TextView>(R.id.gameScore)
        fun bind(data:PrevScore ) {
            scoreText.text = data.score.toString()
        }
    }

    class DiffCall : DiffUtil.ItemCallback<PrevScore>() {
        override fun areItemsTheSame(
            oldItem: PrevScore,
            newItem:PrevScore
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: PrevScore,
            newItem: PrevScore
        ): Boolean {
            return oldItem == newItem
        }
    }

}