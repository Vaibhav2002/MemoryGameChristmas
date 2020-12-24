package com.example.christmasmemorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SelectGameActivity : AppCompatActivity(),onItemCLick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_game)
        val nogames=findViewById<TextView>(R.id.noGame)
        val recyclerView=findViewById<RecyclerView>(R.id.recycle)
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.isVisible=true
        val list= ArrayList<String>()
        val gameadapter=SelectGameAdapter(this)
        recyclerView.adapter=gameadapter
        val database=Firebase.database.reference
        database.child("games").get().addOnSuccessListener { docs->
            for(i in docs.children){
                list.add(i.key.toString())
            }
            gameadapter.submitList(list)
            progressBar.isVisible=false

        }
            .addOnFailureListener{
                Toast.makeText(this@SelectGameActivity,"Failed to load",Toast.LENGTH_SHORT).show()
                progressBar.isVisible=false
            }
    }

    override fun onGameClick(game: String) {
        val intent= Intent()
        intent.putExtra("GameName",game)
        setResult(3,intent)
        finish()
    }
}