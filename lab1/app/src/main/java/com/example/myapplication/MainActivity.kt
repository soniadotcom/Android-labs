
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okButton = findViewById<Button>(R.id.okButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val editText = findViewById<EditText>(R.id.editText)
        val result = findViewById<TextView>(R.id.result)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var radioButton: RadioButton

        val popup = findViewById<TextView>(R.id.popup)
        val popupYesButton = findViewById<Button>(R.id.popupYesButton)
        val popupNoButton = findViewById<Button>(R.id.popupNoButton)

        popup.setVisibility(View.GONE)
        popupYesButton.setVisibility(View.GONE)
        popupNoButton.setVisibility(View.GONE)



        okButton.setOnClickListener {
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)
            Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()

            result.text = editText.text
            if (radioButton.text == "12") {
                result.textSize = 12F
            }
            if (radioButton.text == "16") {
                result.textSize = 16F
            }
            if (radioButton.text == "26") {
                result.textSize = 26F
            }
            if (radioButton.text == "32") {
                result.textSize = 32F
            }
            if (radioButton.text == "None" || editText.text.toString() == "") {
                popup.setVisibility(View.VISIBLE)
                popupYesButton.setVisibility(View.VISIBLE)
                popupNoButton.setVisibility(View.VISIBLE)
            }
        }

        cancelButton.setOnClickListener {
            Toast.makeText(baseContext, "Cleared", Toast.LENGTH_SHORT).show()
            result.text = null
        }

        popupYesButton.setOnClickListener {
            finish()
        }
        popupNoButton.setOnClickListener {
            popup.setVisibility(View.GONE)
            popupYesButton.setVisibility(View.GONE);
            popupNoButton.setVisibility(View.GONE);
        }
    }
}

