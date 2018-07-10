package com.example.mitsukisugiya.tap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count_button: Button = this.findViewById(R.id.count)
        val reset_button: Button = this.findViewById(R.id.reset)
        val text: TextView = this.findViewById(R.id.result)

        var count = 0
        count_button.setOnClickListener { view: View? ->
            count += 1
            text.text = count.toString()
        }
        reset_button.setOnClickListener { view: View? ->
            text.text = this.getString(R.string.initial_text)
            count = 0
        }
    }
}
