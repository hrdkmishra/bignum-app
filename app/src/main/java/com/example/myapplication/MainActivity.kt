package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()

        btnLeft.setOnClickListener {
            // code will run
            checkAnswer(true)
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            // code will run
            checkAnswer(false)
            assignNumbersToButtons()
        }

    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val n1 = btnLeft.text.toString().toInt()
        val n2 = btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) n1 > n2 else n2 > n1
        val toastMessage: String
        val backgroundColor: Int
        if (isAnswerCorrect) {
            toastMessage = "Correct!!"
            backgroundColor = Color.GREEN
        } else {
            toastMessage = "Wrong"
            backgroundColor = Color.RED
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        backgroundView.setBackgroundColor(backgroundColor)
    }
    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = "$leftNum"
        btnRight.text = "$rightNum"
    }
}