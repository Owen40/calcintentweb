package com.webler.calcintentweb

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var backbtn:TextView
    lateinit var callbtn:Button
    lateinit var smsbtn:Button
    lateinit var dialbtn:Button
    lateinit var sharebtn:Button
    lateinit var stkbtn:Button
    lateinit var cambtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        // Back button
        backbtn = findViewById(R.id.txt_back)
        backbtn.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        // CAll all the buttons
        callbtn = findViewById(R.id.btn_call)
        smsbtn = findViewById(R.id.btn_sms)
        dialbtn = findViewById(R.id.btn_dial)
        sharebtn = findViewById(R.id.btn_share)
        stkbtn = findViewById(R.id.btn_stk)
        cambtn = findViewById(R.id.btn_cam)

        // Adding functionallity to the buttons
        smsbtn.setOnClickListener {
            var uri = Uri.parse("smsto:+13419372800")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "Click this link to listen to some tea https://listless17.top")
            startActivity(intent)
        }
        callbtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+13149372800"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }
        cambtn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)
        }
        sharebtn.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }
        stkbtn.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        dialbtn.setOnClickListener {
            val phone = "+13149372800"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }
    }
}