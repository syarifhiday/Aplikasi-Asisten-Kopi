package com.syarifh.asistenkopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_kopi = findViewById(R.id.kopihitam) as LinearLayout
        val btn_air = findViewById<LinearLayout>(R.id.aitputih)
        btn_kopi.setOnClickListener{
            startActivity(Intent(this,PesanKopi::class.java))
        }
        btn_air.setOnClickListener{
            startActivity(Intent(this,PesanAir::class.java))
        }


    }

}