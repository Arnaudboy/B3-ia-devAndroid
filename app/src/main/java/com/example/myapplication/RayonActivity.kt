package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class RayonActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayons)
        setViewTitle("Rayons")
        showBack()

        val rayonArrayList = arrayListOf<Rayon>()

        val recyclerViewRayon = findViewById<RecyclerView>(R.id.recyclerViewRayons)
        recyclerViewRayon.layoutManager = LinearLayoutManager(this)
        val rayonAdapter = RayonAdapter(rayonArrayList)
        recyclerViewRayon.adapter = rayonAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
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

                    val jsRayons = JSONObject(data)
                    val jsArrayRayons = jsRayons.getJSONArray("items")

                    for (i in 0 until jsArrayRayons.length()) {
                        val js = jsArrayRayons.getJSONObject(i)
                        val rayon = Rayon(
                            js.optString("title", "not found"),
                            js.optString("products_url", "not found"),
                        )
                        rayonArrayList.add(rayon)
                        runOnUiThread(Runnable {
                            rayonAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })
    }
}