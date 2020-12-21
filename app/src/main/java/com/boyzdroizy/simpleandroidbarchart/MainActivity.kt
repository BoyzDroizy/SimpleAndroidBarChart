package com.boyzdroizy.simpleandroidbarchart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val chartData = (12 downTo 1).map { Random.nextInt(10, 100) }.toMutableList()
        val intervalData = (12 downTo 1).map { it }.toMutableList()
        simpleBarChart.setChartData(chartData, intervalData)
        simpleBarChart.setMinValue(0)
    }
}