package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class GroupMemberAdapter(val groupMembers: ArrayList<GroupMember>) :
    RecyclerView.Adapter<GroupMemberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): GroupMemberAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.group_member_button_info_activity, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupMemberAdapter.ViewHolder, position: Int) {
        holder.textButton.text = "Etudiant " + (position + 1).toString()


    }

    override fun getItemCount(): Int {
        return groupMembers.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textButton = view.findViewById<TextView>(R.id.groupMemberInfo)
        val t = view.findViewById<LinearLayout>(R.id.layoutContent)
        val con = t.context
        init {
            t.setOnClickListener(View.OnClickListener {
                val newIntent = Intent(con, StudentActivity::class.java)
                con.startActivity(newIntent)
            })
        }

    }
}