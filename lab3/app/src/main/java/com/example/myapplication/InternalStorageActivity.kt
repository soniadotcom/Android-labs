package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class InternalStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)

        val data: String = readInternalStorage("orderData")
        val internalStorageFragment = InternalStorageFragment()
        val bundle = Bundle()

        bundle.putString("storage", data)
        internalStorageFragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.storage_fragment_layout, internalStorageFragment)
            .commit()
    }

    private fun readInternalStorage(fileName: String): String{

        val fileInputStream: FileInputStream? = openFileInput(fileName)
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String?
        while (run {
                text = bufferedReader.readLine()
                text
            } != null) {
            stringBuilder.append(text)
        }
        return stringBuilder.toString()
    }
}