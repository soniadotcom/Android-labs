package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.FileOutputStream
import java.lang.Exception
import java.io.*

class MainActivity  : AppCompatActivity(), ContentFragment.OnTextSent, ContentFragment.ShowStorage  {

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

            writeFileOnInternalStorage("orderData", "\n" + resultText + " " + resultFontSize)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_block, resultFragment).addToBackStack(null).commit()

        } else {
            Toast.makeText(applicationContext, "Input field empty!", Toast.LENGTH_SHORT).show()
        }
    }


    override fun show() {
        val intent = Intent(this, InternalStorageActivity::class.java)
        startActivity(intent)
    }

    private fun writeFileOnInternalStorage(fileName: String, fileData: String) {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND)
            fileOutputStream.write(("$fileData, \r\n").toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}

