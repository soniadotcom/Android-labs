package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val resultText = arguments?.getString("resultText")
        val resultFontSize = arguments?.getFloat("resultFontSize")

        val textView: TextView = view?.findViewById(R.id.fragmentResultText) as TextView

        textView.text = resultText
        textView.textSize = resultFontSize!!

        textView.setText(resultText)
        textView.setTextSize(resultFontSize)
    }
}