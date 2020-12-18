package com.boyzdroizy.simpleandroidbarchart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val chartData = mutableListOf<Any>("", "", "", "", "", "", "", "", "", "", "", "")
        val intervalData = mutableListOf<Any>("", "", "", "", "", "", "")


        simpleBarChart.setChartData(chartData, intervalData)

        simpleBarChart.setMaxValue("$120")
        simpleBarChart.setMinValue("$0")
    }
}