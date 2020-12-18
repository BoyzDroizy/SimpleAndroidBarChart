package com.boyzdroizy.simpleandroidbarchart.utils

import android.content.res.Resources
import android.os.Looper
import android.view.View


fun View.alphaShow() {
    this.alpha = 1f
}

fun View.alphaHide() {
    this.alpha = 0f
}

fun View.setClickListenerWithDelay(duration: Long, function: () -> Unit) {
    this.setOnClickListener {
        this.isClickable = false
        function()
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            this.isClickable = true
        }, duration)
    }
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
