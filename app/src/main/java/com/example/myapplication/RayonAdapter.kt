package com.example.myapplication

import android.content.Intent
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
        holder.rayonButton.text = rayon.title
        holder.rayonButton.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.context, ProductListActivity()::class.java)
            newIntent.putExtra("url", rayon.url)
            newIntent.putExtra("title", rayon.title)
            holder.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return rayons.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rayonButton = view.findViewById<Button>(R.id.rayonButton)
        val layoutContent = view.findViewById<LinearLayout>(R.id.rayonRecyclerViewLayout)
        val context = layoutContent.context
    }
}