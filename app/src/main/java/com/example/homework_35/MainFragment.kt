package com.example.homework_35

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private var count = 0
    private var isCountingUp = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        button = view.findViewById(R.id.button)
        textView = view.findViewById(R.id.textView)
        updateTextView()

        button.setOnClickListener {
            onButtonClick()
        }

        return view
    }

    private fun onButtonClick() {
        if (isCountingUp) {
            count++
            if (count == 10) {
                isCountingUp = false
                button.text = "-1"
            }
        } else {
            count--
            if (count == 0) {

                val secondFragment = SecondFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, secondFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return
            }
        }
        updateTextView()
    }

    private fun updateTextView() {
        textView.text = count.toString()
    }
}