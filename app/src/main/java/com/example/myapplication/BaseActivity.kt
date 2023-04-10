package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setViewTitle( title:String?){
        val textTitle= findViewById<TextView>(R.id.textViewTitle)
        textTitle.setText(title)
    }

    fun showBack() {
        val backLogo=findViewById<ImageView>(R.id.imageViewBack)
        backLogo.visibility= View.VISIBLE
        backLogo.setOnClickListener(View.OnClickListener {
            this.finish()
        })
    }
}