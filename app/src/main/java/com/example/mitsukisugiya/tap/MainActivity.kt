package com.example.mitsukisugiya.tap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.util.Log

import java.text.SimpleDateFormat
import java.util.Date

import java.lang.Thread.sleep
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // date
        val date: Date = Date()
        val df = SimpleDateFormat("yyyy/MM/dd")
        val date_view: TextView = this.findViewById(R.id.date)
        date_view.text = df.format(date)


        val count_button: Button = this.findViewById(R.id.count)
        val reset_button: Button = this.findViewById(R.id.reset)
        val text: TextView = this.findViewById(R.id.result)


        // start loop log
        thread { count_loop() }

        var count = 0
        count_button.setOnClickListener { view: View? ->
            thread {
                count += 1
                text.text = count.toString()
            }
        }
        reset_button.setOnClickListener { view: View? ->
            text.text = this.getString(R.string.initial_text)
            count = 0
        }

    }

    private fun count_loop(){
        do {
            for (i in 1..100) {
                Log.d("MainActivity", i.toString())
                sleep(1000)
            }
        } while(true)
    }
}
