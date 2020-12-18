package com.boyzdroizy.simpleandroidbarchart.utils

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import kotlin.math.abs


class ProgressBarAnimation(private val progressBar: ProgressBar, fullDuration: Long) : Animation() {
    private var valueTo = 0
    private var valueFrom = 0
    private val mStepDuration: Long = fullDuration / progressBar.max

    fun setProgress(barProgress: Int) {
        var progress = barProgress
        if (progress < 0) {
            progress = 0
        }
        if (progress > progressBar.max) {
            progress = progressBar.max
        }
        valueTo = progress
        valueFrom = progressBar.progress
        duration = abs(valueTo - valueFrom) * mStepDuration
        progressBar.startAnimation(this)
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        val value = valueFrom + (valueTo - valueFrom) * interpolatedTime
        progressBar.progress = value.toInt()
    }

}