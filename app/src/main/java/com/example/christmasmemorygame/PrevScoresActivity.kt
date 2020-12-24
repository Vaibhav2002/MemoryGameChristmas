package com.example.christmasmemorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.christmasmemorygame.local.ScoreDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import org.w3c.dom.Text

class PrevScoresActivity : AppCompatActivity() {
    @InternalCoroutinesApi
    private val dao= ScoreDatabase.getInstance(this).getDao()
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prev_scores)

        val recycler=findViewById<RecyclerView>(R.id.scorerecycle)
        val textView=findViewById<TextView>(R.id.noScore)

        val scoreAdapter=ScoreAdapter()
        recycler.adapter=scoreAdapter
        dao.getPrevScores().observe(this, Observer { data->
            scoreAdapter.submitList(data)
        })
    }
}