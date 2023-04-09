package com.example.myapplication

class GroupMember(val firstName: String,
                  val lastName: String,
                  val email: String) {
    fun getLogoName(): String {
        return firstName+"_logo.jpg"
    }
}