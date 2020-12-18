package com.boyzdroizy.simpleandroidbarchart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.boyzdroizy.simpleandroidbarchart.R
import com.boyzdroizy.simpleandroidbarchart.utils.*
import com.boyzdroizy.simpleandroidbarchart.utils.Utils.getLocationOnScreen
import kotlinx.android.synthetic.main.adapter_bar_chart.view.*
import kotlin.random.Random

class BarChartAdapter(
    private val items: MutableList<Any>,
    private val chartInterface: ChartInterface
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var selectedView: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_bar_chart, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items[position], position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Any, position: Int) {
            itemView.let { view ->
                view.chart_value.text = position.inc().toString()
                initProgressBar(view.progressBar, Random.nextInt(10, 100))
                displayIndicatorFunc(view)
            }
        }

        private fun initProgressBar(processBar: ProgressBar, value: Int) {
            processBar.progress = 0
            processBar.max = 1000

            ProgressBarAnimation(processBar, PROGRESS_ANIMATION).apply {
                setProgress(value * 10)
            }
        }

        private fun displayIndicatorFunc(view: View) {
            view.container.setClickListenerWithDelay(Constants.DELAY_DEBOUNCE) {

                view.indicator.postDelayed({
                    if (selectedView != view) {
                        view.indicator.alphaShow()
                        selectedView?.indicator?.alphaHide()
                        selectedView = view
                    } else {
                        if (view.indicator.alpha == 0f) view.indicator.alphaShow()
                        else view.indicator.alphaHide()
                    }


                    val location = getLocationOnScreen(view.indicator)
                    chartInterface.onChartValueSelected(
                        location.x,
                        view.indicator.alpha,
                        view.progressBar.progress
                    )
                }, 50)
            }
        }
    }

    interface ChartInterface {
        fun onChartValueSelected(x: Int, alpha: Float, value: Int)
    }

    companion object {
        const val PROGRESS_ANIMATION = 2000L
    }
}