package com.example.mitsukisugiya.tap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = this.findViewById<TextView>(R.id.count_text)
        var count: Int by Delegates.observable(0) { _, _, new ->
            text.text = new.toString()
        }

        this.findViewById<Button>(R.id.count_up_button).setOnClickListener {
            count = count + 1
        }
        this.findViewById<Button>(R.id.reset_button).setOnClickListener {
            count = 0
        }
    }
}
