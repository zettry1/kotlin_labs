package com.example.miu_mobile_assignemnt

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miu_mobile_assignemnt.modal.Product

class ShoppingActivity: AppCompatActivity() {
    private val p1 = Product("my prod", R.drawable.walmart_logo)
    private val p2 = Product("roller", R.drawable.walmart_logo)
    private val p3 = Product("keyboard", R.drawable.walmart_logo)
    private val p4 = Product("mouse", R.drawable.walmart_logo)
    private val p5 = Product("pad", R.drawable.walmart_logo)

    private val products = mutableListOf<Product>(p1, p2, p3, p4, p5)
    private var username = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        if (intent.getStringExtra("email") != null) {
            username = intent.getStringExtra("email").toString()
            val profile = findViewById<TextView>(R.id.email)
            profile.text = "Welcome! $username"
        }

        var  gridView= findViewById<GridView>(R.id.maingrid)
//        var baseadapter=BaseAdapter
                products.map {it->{
            var nameView = findViewById<TextView>(R.id.label)
            var imageView = findViewById<ImageView>(R.id.image)
            imageView.setImageResource(it.img)
            nameView.text = it.name
            gridView.addView(nameView)
        } }
//        gridView.adapter

//        gridView.addView()


//        val adapter = GridAdapter(products, this)
//        val grid = findViewById<GridView>(R.id.grid)
//        grid.adapter = adapter
//
        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext, "you selected:"+products[position].name + " ", Toast.LENGTH_SHORT
            ).show()
        }
    }
}