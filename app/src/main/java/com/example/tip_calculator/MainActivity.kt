package com.example.tip_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numberOne=findViewById<EditText>(R.id.TextNumberDecimalOne)
        val numberTwo=findViewById<EditText>(R.id.TextNumberDecimalTwo)
        val finalAmount=findViewById<TextView>(R.id.textViewSecond)
        val btn= findViewById<Button>(R.id.button)
        var totalAmt=0.0
        val roundUpSwitch = findViewById<Switch>(R.id.switchOne)






        btn.setOnClickListener{
            val numOne=numberOne.text.toString().toDoubleOrNull()?:0.0
            val numTwo=numberTwo.text.toString().toDoubleOrNull()?:0.0
            var tipAmt=((numTwo)/100)*numOne

            if (roundUpSwitch.isChecked) {
                tipAmt = kotlin.math.ceil(tipAmt) // Round up the tip amount
            }
            totalAmt=tipAmt+numOne
            finalAmount.text="Your Final Bill Amount :$${totalAmt.toString()}"

        }


    }
}