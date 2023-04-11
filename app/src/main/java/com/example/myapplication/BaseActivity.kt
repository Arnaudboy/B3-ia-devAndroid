package com.example.myapplication

import android.content.res.Resources.getSystem
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setViewTitle( title:String?){
        val textTitle= findViewById<TextView>(R.id.textViewTitle)
        textTitle.setText(title)
    }

    fun showBack() {
        val textView = findViewById<TextView>(R.id.textViewTitle)
        val backLogo=findViewById<ImageView>(R.id.imageViewBack)
        backLogo.visibility= View.VISIBLE

        val layoutParams = textView.layoutParams as RelativeLayout.LayoutParams
        val px = (60 * getSystem().displayMetrics.density).toInt()
        layoutParams.setMargins(px, 0, 0, 0)
        backLogo.setOnClickListener(View.OnClickListener {
            this.finish()
        })
    }
}