package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.ClassCastException


class ContentFragment : Fragment(){
    private lateinit var onTextSentListener: OnTextSent
    private lateinit var onShowStorage: ShowStorage

    interface OnTextSent {
        fun sendData(
            resultText: String,
            resultFontSize: Float,
            isNone: Boolean
        )
    }

    interface ShowStorage {
        fun show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onTextSentListener = context as OnTextSent
            onShowStorage = context as ShowStorage
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onTextSent"
            )
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val okButton = view?.findViewById(R.id.okButton) as Button
        val cancelButton = view?.findViewById(R.id.cancelButton) as Button
        val editText = view?.findViewById(R.id.editText) as EditText

        val radioGroup = view?.findViewById(R.id.radioGroup) as RadioGroup
        var radioButton: RadioButton


        val popup = view?.findViewById<TextView>(R.id.popup)
        popup!!.setVisibility(View.GONE)

        var resultFontSize = 12F
        var resultText = "Hello world!"
        var isNone = false

        val showStorageButton = view?.findViewById(R.id.storageButton) as Button

        okButton.setOnClickListener {
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = view?.findViewById(intSelectButton) as RadioButton


            resultText = editText.text.toString()


            if (radioButton.text == "12") {
                resultFontSize = 12F
            }
            if (radioButton.text == "16") {
                resultFontSize = 16F
            }
            if (radioButton.text == "26") {
                resultFontSize = 26F
            }
            if (radioButton.text == "32") {
                resultFontSize = 32F
            }


            isNone = radioButton.text == "None"

            if (radioButton.text == "None" || editText.text.isEmpty()) {
                popup!!.setVisibility(View.VISIBLE)
            }
            else if(radioButton.text != "None" && editText.text.isNotEmpty()){
                popup!!.setVisibility(View.GONE)
            }

            passData(
                resultText,
                resultFontSize,
                isNone
            )
        }

        cancelButton.setOnClickListener {
            editText.setText("")
        }

        showStorageButton.setOnClickListener {
            showStorage()
        }

    }

    private fun showStorage() {
        if (::onShowStorage.isInitialized) {
            onShowStorage.show()
        }
    }

    private fun passData(
        resultText: String,
        resultFontSize: Float,
        isNone: Boolean
    ) {
        onTextSentListener.sendData(
            resultText,
            resultFontSize,
            isNone
        )
    }
}