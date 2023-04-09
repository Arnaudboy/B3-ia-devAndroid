package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewTitle("EPSI")
        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, InfoActivity::class.java)
            startActivity(newIntent)
        })
        val buttonProducts = findViewById<Button>(R.id.buttonProducts)
        buttonProducts.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, ProduitsActivity::class.java)
            startActivity(newIntent)
        })
    }
}