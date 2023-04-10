package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class StudentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBack()
        val lastName = intent.getStringExtra("lastName")
        val firstName = intent.getStringExtra("firstName")
        setViewTitle(lastName)

        val logo = findViewById<ImageView>(R.id.imageView)
        val logoName = firstName?.lowercase() + "_logo"
        val resourceId = resources.getIdentifier(logoName, "drawable", applicationContext.packageName)
        logo.setImageResource(resourceId)

        val name = findViewById<TextView>(R.id.firstLastName)
        name.text = lastName + " " + firstName

        val email = findViewById<TextView>(R.id.email)
        email.text = intent.getStringExtra("email")
    }
}