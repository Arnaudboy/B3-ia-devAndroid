package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")
        setViewTitle(name)
        showBack()

        val image = findViewById<ImageView>(R.id.productDetailImage)
        Picasso.get().load(imageUrl).into(image)

        val descriptionText = findViewById<TextView>(R.id.productDetailDescription)
        descriptionText.text = description
    }
}