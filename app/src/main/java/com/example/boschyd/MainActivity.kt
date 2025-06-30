package com.example.boschyd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflation

    }

    fun handleClick(view: View) {
        var clMain:ConstraintLayout = findViewById(R.id.maincl)
        Snackbar.make(clMain,"button clicked",Snackbar.LENGTH_SHORT).show()
        var nameEt:EditText = findViewById(R.id.etName) //taking handle
        var name:String = nameEt.text.toString()
        val resultTv:TextView = findViewById(R.id.tvResult)
        resultTv.setText(name)
    }

    fun dialNo(view: View) {
        //https://developer.android.com/guide/components/intents-common
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"))
        startActivity(dialIntent)
    }
}