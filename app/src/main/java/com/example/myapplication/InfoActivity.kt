package com.example.myapplication

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setViewTitle("Infos")
        showBack()

        val groupMemberArrayList = arrayListOf<GroupMember>()
        val groupMember1 =  GroupMember("Arnaud", "BOYER", "arnaud.boyer4@epsi.fr")
        val groupMember2 = GroupMember("Quentin", "SAR", "quentin.sar@epsi.fr")
        groupMemberArrayList.add(groupMember1)
        groupMemberArrayList.add(groupMember2)

        val recyclerViewGroupMembers = findViewById<RecyclerView>(R.id.recyclerViewGroupMember)
        recyclerViewGroupMembers.layoutManager = LinearLayoutManager(this)
        val groupMemberAdapter = GroupMemberAdapter(groupMemberArrayList)
        recyclerViewGroupMembers.adapter = groupMemberAdapter
    }
}