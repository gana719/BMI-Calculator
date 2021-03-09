package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMICalculator : AppCompatActivity() {
    var bmiIndex : Double = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i_calculator)


        val personName = intent.getStringExtra("personName")
        val tv = findViewById<TextView>(R.id.usernameText)
        tv.setText(personName)


        val calculateBtn = findViewById<Button>(R.id.calculateButton)

        if(savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if(bmiIndex != 0.0){
                val tvStatus = findViewById<TextView>(R.id.statusText)
                tvStatus.setText(getStatus())
            }
        }

        calculateBtn.setOnClickListener(){
            val weight = findViewById<TextView>(R.id.weightInput).text.toString()
            val height = findViewById<TextView>(R.id.heightInput).text.toString()
            val tvStatus = findViewById<TextView>(R.id.statusText)
            bmiIndex = weight.toDouble() / (height.toDouble()*height.toDouble())

            tvStatus.setText(getStatus())

        }



    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiIndex",bmiIndex)
    }

    fun getStatus():String {

        if (bmiIndex < 18.5)
            return "Underweight"
        else if (bmiIndex <= 24.9)
            return "Normal weight"
        else if (bmiIndex <= 29.9)
            return "Overweight"
        else if (bmiIndex <= 34.9)
            return "Obesity class 1"
        else if (bmiIndex <= 39.9)
            return "Obesity class 2"
        else return "Obesity class 3"
    }
}