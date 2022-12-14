package com.syarifh.asistenkopi

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

class PesanKopi : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_kopi)

        var gula:String?=null
//        deklarasi jenis gula
        val pahit = findViewById<LinearLayout>(R.id.pahit)
        val less_sugar = findViewById<LinearLayout>(R.id.less_sugar)
        val normal = findViewById<LinearLayout>(R.id.normal)
        val manis = findViewById<LinearLayout>(R.id.manis)

        val textPahit = findViewById<TextView>(R.id.textPahit)
        val textLessSugar = findViewById<TextView>(R.id.textLessSugar)
        val textNormal = findViewById<TextView>(R.id.textNormal)
        val textManis = findViewById<TextView>(R.id.textManis)
//        Pemilihan gula
        pahit.setOnClickListener{
            less_sugar.setBackgroundResource(R.drawable.rounded_light_stroke)
            normal.setBackgroundResource(R.drawable.rounded_light_stroke)
            manis.setBackgroundResource(R.drawable.rounded_light_stroke)
            less_sugar.setPadding(34,20,34,20)
            normal.setPadding(34,20,34,20)
            manis.setPadding(34,20,34,20)
            textLessSugar.setTextColor(getColorStateList(R.color.light))
            textNormal.setTextColor(getColorStateList(R.color.light))
            textManis.setTextColor(getColorStateList(R.color.light))

            pahit.setBackgroundResource(R.drawable.rounded_light)
            pahit.setPadding(34,20,34,20)
            textPahit.setTextColor(getColorStateList(R.color.primary))

            gula = "pahit"
        }
        less_sugar.setOnClickListener{
            pahit.setBackgroundResource(R.drawable.rounded_light_stroke)
            normal.setBackgroundResource(R.drawable.rounded_light_stroke)
            manis.setBackgroundResource(R.drawable.rounded_light_stroke)
            pahit.setPadding(34,20,34,20)
            normal.setPadding(34,20,34,20)
            manis.setPadding(34,20,34,20)
            textPahit.setTextColor(getColorStateList(R.color.light))
            textNormal.setTextColor(getColorStateList(R.color.light))
            textManis.setTextColor(getColorStateList(R.color.light))

            less_sugar.setBackgroundResource(R.drawable.rounded_light)
            less_sugar.setPadding(34,20,34,20)
            textLessSugar.setTextColor(getColorStateList(R.color.primary))

            gula = "less_sugar"
        }
        normal.setOnClickListener{
            less_sugar.setBackgroundResource(R.drawable.rounded_light_stroke)
            pahit.setBackgroundResource(R.drawable.rounded_light_stroke)
            manis.setBackgroundResource(R.drawable.rounded_light_stroke)
            less_sugar.setPadding(34,20,34,20)
            pahit.setPadding(34,20,34,20)
            manis.setPadding(34,20,34,20)
            textLessSugar.setTextColor(getColorStateList(R.color.light))
            textPahit.setTextColor(getColorStateList(R.color.light))
            textManis.setTextColor(getColorStateList(R.color.light))

            normal.setBackgroundResource(R.drawable.rounded_light)
            normal.setPadding(34,20,34,20)
            textNormal.setTextColor(getColorStateList(R.color.primary))

            gula = "normal"
        }
        manis.setOnClickListener{
            less_sugar.setBackgroundResource(R.drawable.rounded_light_stroke)
            normal.setBackgroundResource(R.drawable.rounded_light_stroke)
            pahit.setBackgroundResource(R.drawable.rounded_light_stroke)
            less_sugar.setPadding(34,20,34,20)
            normal.setPadding(34,20,34,20)
            pahit.setPadding(34,20,34,20)
            textLessSugar.setTextColor(getColorStateList(R.color.light))
            textNormal.setTextColor(getColorStateList(R.color.light))
            textPahit.setTextColor(getColorStateList(R.color.light))

            manis.setBackgroundResource(R.drawable.rounded_light)
            manis.setPadding(34,20,34,20)
            textManis.setTextColor(getColorStateList(R.color.primary))

            gula = "manis"
        }

        val lanjutkan = findViewById<Button>(R.id.lanjutkan)
        lanjutkan.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            if(gula == null){
                //tampilkan dialog suruh pilih gula
                builder.setTitle("Ups")
                builder.setMessage("Silahkan pilih gula dulu")
                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                }

                builder.show()
            }else{
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
}