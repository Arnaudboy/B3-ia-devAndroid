package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RayonAdapter(val rayons: ArrayList<Rayon>) : RecyclerView.Adapter<RayonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): RayonAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rayons_recyclerview, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val rayon = rayons.get(position)
        Log.e("R", rayon.title)
        holder.rayonButton.text = rayon.title
    }

    override fun getItemCount(): Int {
        return rayons.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rayonButton = view.findViewById<Button>(R.id.rayonButton)
    }
}