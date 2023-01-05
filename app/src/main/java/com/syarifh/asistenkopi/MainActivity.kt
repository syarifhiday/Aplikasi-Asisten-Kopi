package com.syarifh.asistenkopi

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

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

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.w(TAG, token)

            // Log and toast
//            val msg = getString(R.string.msg_token_fmt, token)
            Log.w(TAG, FirebaseMessaging.getInstance().getToken().toString())
        })

    }

}