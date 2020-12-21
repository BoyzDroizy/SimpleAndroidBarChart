package com.boyzdroizy.simpleandroidbarchart

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.core.view.marginStart
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.boyzdroizy.simpleandroidbarchart.adapters.BarChartAdapter
import com.boyzdroizy.simpleandroidbarchart.adapters.BarIntervalsAdapter
import com.boyzdroizy.simpleandroidbarchart.utils.Utils
import com.boyzdroizy.simpleandroidbarchart.utils.alphaHide
import com.boyzdroizy.simpleandroidbarchart.utils.px
import kotlinx.android.synthetic.main.bar_chart.view.*
import kotlin.random.Random


class SimpleBarChart @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), BarChartAdapter.ChartInterface,
    BarIntervalsAdapter.IntervalsInterface {

    override fun onIntervalSelected(value: String) {
        val list = (1..value.toInt()).map { Random.nextInt(10, 100) }
        initAnalyticsChartAdapter(list.toMutableList())
    }

    override fun onChartValueSelected(x: Int, alpha: Float, value: Int) {
        max_value_label.text = "$$value"
        graphLabel.post {
            chartLayout.marginStart
            val xParent = Utils.getLocationOnScreen(chartLayout).x - chartLayout.marginStart
            val xEndParent = xParent + chartLayout.measuredWidth
            val widthLabel = graphLabel.measuredWidth

            if (alpha == 1f) {
                graphLabel.x = when {
                    x - widthLabel <= xParent -> xParent.toFloat() + border.px
                    x + widthLabel / 2 > xEndParent -> xEndParent.toFloat() - widthLabel - border.px
                    else -> x.toFloat() - (widthLabel / 2) - chartLayout.marginStart
                }
            }

            graphLabel.postDelayed({ graphLabel.alpha = alpha }, 30)
        }
    }

    private fun initView(context: Context) {
        View.inflate(context, R.layout.bar_chart, this)
    }


    private fun initAnalyticsChartAdapter(items: MutableList<Int>) {
        graphLabel.alphaHide()
        setMaxValue(items.max() ?: 0)
        val classesAdapter = BarChartAdapter(items, this)
        chart_recycler.layoutManager = GridLayoutManager(this.context, items.size)
        chart_recycler.adapter = classesAdapter
    }

    private fun initAnalyticsIntervalsAdapter(items: MutableList<Int>) {
        val classesAdapter = BarIntervalsAdapter(items, this)
        dates_recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        dates_recycler.adapter = classesAdapter
    }

    init {
        initView(context)
    }

    fun setChartData(chartData: MutableList<Int>, intervals: MutableList<Int>) {
        initAnalyticsChartAdapter(chartData)
        initAnalyticsIntervalsAdapter(intervals)
    }

    fun setMaxValue(maxValue: Int) {
        max_value.text = maxValue.toString()
    }

    fun setMinValue(minValue: Int) {
        min_value.text = minValue.toString()
    }

    companion object {
        private const val border = 2
    }

}