package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity  : AppCompatActivity(), ContentFragment.OnTextSent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contentFragment = ContentFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_block, contentFragment)
            .commit()
    }

    override fun sendData(
        resultText: String,
        resultFontSize: Float,
        isNone: Boolean
    ) {
        val resultFragment = ResultFragment()
        val bundle = Bundle()

        if (resultText.isNotEmpty() && !isNone) {
            bundle.putString("resultText", resultText)
            bundle.putFloat("resultFontSize", resultFontSize)

            resultFragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_block, resultFragment).addToBackStack(null).commit()

        } else {
            Toast.makeText(applicationContext, "Input field empty!", Toast.LENGTH_SHORT).show()
        }
    }

}

