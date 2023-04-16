package com.webler.calcintentweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcActivity : AppCompatActivity() {
    lateinit var backbtn:TextView
    lateinit var answertxt:TextView
    lateinit var fnum:EditText
    lateinit var secnum:EditText
    lateinit var addbtn:Button
    lateinit var subbtn:Button
    lateinit var divbtn:Button
    lateinit var multbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        // Back button
        backbtn = findViewById(R.id.txt_back)
        backbtn.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // call buttons and textbox
        addbtn = findViewById(R.id.btn_add)
        subbtn = findViewById(R.id.btn_sub)
        divbtn = findViewById(R.id.btn_div)
        multbtn = findViewById(R.id.btn_multiply)

        //functionabil;ity of the page
        addbtn.setOnClickListener {
            var num1 = fnum.text.toString()
            var num2 = secnum.text.toString()
            if (num1.isEmpty() && num2.isEmpty()) {
                answertxt.text = "Please fill all the fields"
            } else {
                var answer = num1.toDouble() + num2.toDouble()
                answertxt.text = answer.toString()
            }
        }
        subbtn.setOnClickListener {
            var num1 = fnum.text.toString()
            var num2 = secnum.text.toString()
            if (num1.isEmpty() && num2.isEmpty()) {
                answertxt.text = "Please fill all the fields"
            } else {
                var answer = num1.toDouble() - num2.toDouble()
                answertxt.text = answer.toString()
            }
        }
        divbtn.setOnClickListener {
            var num1 = fnum.text.toString()
            var num2 = secnum.text.toString()
            if (num1.isEmpty() && num2.isEmpty()) {
                answertxt.text = "Please fill all the fields"
            } else {
                var answer = num1.toDouble() / num2.toDouble()
                answertxt.text = answer.toString()
            }
        }
        multbtn.setOnClickListener {
            var num1 = fnum.text.toString()
            var num2 = secnum.text.toString()
            if (num1.isEmpty() && num2.isEmpty()) {
                answertxt.text = "Please fill all the fields"
            } else {
                var answer = num1.toDouble() * num2.toDouble()
                answertxt.text = answer.toString()
            }
        }
    }
}