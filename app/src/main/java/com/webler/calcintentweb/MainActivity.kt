package com.webler.calcintentweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var calcbtn:Button
    lateinit var intentbtn:Button
    lateinit var webbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Check id
        calcbtn = findViewById(R.id.btn_calc)
        intentbtn = findViewById(R.id.btn_intent)
        webbtn = findViewById(R.id.btn_web)

        // functionallity of the button
        calcbtn.setOnClickListener {
            var intent = Intent(this,CalcActivity::class.java)
            startActivity(intent)
        }
        intentbtn.setOnClickListener {
            var intent = Intent(this,IntentActivity::class.java)
            startActivity(intent)
        }
        webbtn.setOnClickListener {
            var intent = Intent(this,WebActivity::class.java)
            startActivity(intent)
        }
    }
}