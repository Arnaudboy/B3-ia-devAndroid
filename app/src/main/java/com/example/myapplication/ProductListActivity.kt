package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductListActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        var title = intent.getStringExtra("title")
        var listUrl = intent.getStringExtra("url")
        setViewTitle(title)
        showBack()

        val productArrayList = arrayListOf<Product>()

        val recyclerViewProduct = findViewById<RecyclerView>(R.id.recyclerViewProductList)
        recyclerViewProduct.layoutManager = LinearLayoutManager(this)
        val productListAdapter = ProductListAdapter(productArrayList)
        recyclerViewProduct.adapter = productListAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(listUrl.toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Epsi", "############## " + e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if (data != null && response.code == 200) {

                    val jsProducts = JSONObject(data)
                    val jsArrayProducts = jsProducts.getJSONArray("items")

                    for (i in 0 until jsArrayProducts.length()) {
                        val js = jsArrayProducts.getJSONObject(i)
                        val rayon = Product(
                            js.optString("name", "not found"),
                            js.optString("description", "not found"),
                            js.optString("picture_url", "not found"),
                        )
                        productArrayList.add(rayon)
                        runOnUiThread(Runnable {
                            productListAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })
    }
}