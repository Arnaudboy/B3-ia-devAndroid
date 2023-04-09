package com.example.myapplication

import android.os.Bundle
class InfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)
        setViewTitle("Info")
        showBack()

        val groupMemberArrayList = ArrayList<GroupMember>()
        val groupMember1 =  GroupMember("Arnaud", "BOYER", "arnaud.boyer4@epsi.fr")
        val groupMember2 = GroupMember("Quentin", "SAR", "quentin.sar@epsi.fr")
        groupMemberArrayList.add(groupMember1)
        groupMemberArrayList.add(groupMember2)
    }
}