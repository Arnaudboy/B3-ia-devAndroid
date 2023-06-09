package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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

        val button = findViewById<Button>(R.id.url_school)
        button.setOnClickListener {
            val url = getString(R.string.url)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}