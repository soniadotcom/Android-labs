package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class InternalStorageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_int_storage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val internalStorageData = arguments?.getString("storage")
        val textView: TextView = view?.findViewById(R.id.internalStorage) as TextView

        if (internalStorageData == "" || internalStorageData == null) {
            textView.text = "Internal storage is empty"
        }

        textView.text = internalStorageData
    }
}