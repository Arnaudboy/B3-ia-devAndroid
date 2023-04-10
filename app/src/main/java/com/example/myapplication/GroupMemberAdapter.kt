package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.LinearLayout
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
        val student = groupMembers.get(position)
        holder.textButton.text = "Etudiant " + (position + 1).toString()
        Log.e("ENCULEEEEEEEEEEEEE", holder.layoutContent.context.toString())
        holder.button.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.context, StudentActivity()::class.java)
            newIntent.putExtra("firstName", student.firstName)
            newIntent.putExtra("lastName", student.lastName)
            newIntent.putExtra("email", student.email)
            holder.context.startActivity(newIntent)
        })

    }

    override fun getItemCount(): Int {
        return groupMembers.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textButton = view.findViewById<TextView>(R.id.groupMemberInfo)
        val button = view.findViewById<Button>(R.id.groupMemberInfo)
        val layoutContent = view.findViewById<LinearLayout>(R.id.infoSutdentLayout)
        val context = layoutContent.context
    }
}