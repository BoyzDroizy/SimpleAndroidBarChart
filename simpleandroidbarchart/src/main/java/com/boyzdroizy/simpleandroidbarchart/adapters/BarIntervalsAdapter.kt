package com.boyzdroizy.simpleandroidbarchart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.boyzdroizy.simpleandroidbarchart.R
import kotlinx.android.synthetic.main.adapter_bar_interval.view.*

class BarIntervalsAdapter(
    private val items: MutableList<Any>,
    private val intervalsInterface: IntervalsInterface
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var selectedPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_bar_interval, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items[position], position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Any, position: Int) {
            itemView.let { view ->
                val value = mutableListOf(7, 12).random()
                view.value.text = "$value"

                displaySelectionFunc(view, position)
            }
        }

        private fun displaySelectionFunc(view: View, position: Int) {

            if (selectedPosition == position) {
                selectedItem(view)
            } else {
                unselectedItem(view)
            }

            view.container.setOnClickListener {
                if (selectedPosition != position) {
                    intervalsInterface.onIntervalSelected(view.value.text.toString())
                    selectedPosition = position
                    notifyDataSetChanged()
                }
            }
        }

        private fun selectedItem(view: View) {
            view.value.setTextColor(ContextCompat.getColor(view.context, R.color.colorPrimary))
            view.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorAccent
                )
            )
        }

        private fun unselectedItem(view: View) {
            view.value.setTextColor(ContextCompat.getColor(view.context, R.color.darkerGray))
            view.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorPrimary
                )
            )
        }
    }

    interface IntervalsInterface {
        fun onIntervalSelected(value: String)
    }
}