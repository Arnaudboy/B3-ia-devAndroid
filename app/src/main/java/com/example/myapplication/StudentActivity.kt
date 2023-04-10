package com.example.myapplication

import android.os.Bundle

class StudentActivity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val pathToLogo: String) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        setViewTitle("lastName")
        showBack()
    }
}