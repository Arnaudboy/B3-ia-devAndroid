package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductListAdapter(val productList: ArrayList<Product>) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_list_recyclerview, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val product = productList.get(position)
        holder.name.text = product.name
        holder.descirption.text = product.description
        Picasso.get().load(product.imageUrl).into(holder.image)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.context, ProductActivity()::class.java)
            newIntent.putExtra("name", product.name)
            newIntent.putExtra("description", product.description)
            newIntent.putExtra("imageUrl", product.imageUrl)
            holder.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.productImage)
        val name = view.findViewById<TextView>(R.id.productName)
        val descirption = view.findViewById<TextView>(R.id.productDescription)
        val layoutContent = view.findViewById<LinearLayout>(R.id.recyclerViewProductListLayout)
        val context = layoutContent.context
    }
}