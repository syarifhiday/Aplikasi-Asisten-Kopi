package com.syarifh.asistenkopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class PesanAir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_air)

        var lanjutkan = findViewById<Button>(R.id.lanjutkan)

        var gula:String?= "putih"

        lanjutkan.setOnClickListener{
            //kirim data ke firebase
            val database = FirebaseDatabase.getInstance().getReference("Pesanan")
            val Pesanan = Pesanan(gula, "diproses")
            database.child("pesan").setValue(Pesanan).addOnSuccessListener {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}