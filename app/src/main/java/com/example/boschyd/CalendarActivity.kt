package com.example.boschyd

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity


class CalendarActivity : AppCompatActivity() {
    lateinit var cpList:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        cpList = findViewById(R.id.listView) //socket

        val uriSms = Uri.parse("content://sms/inbox")
        val dataCursor: Cursor = getContentResolver().query(uriSms, null, null, null, null)!!
        var from = arrayOf("address","body")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

        var adapter:SimpleCursorAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,dataCursor,from,to,1)
        cpList.adapter = adapter
    }
}