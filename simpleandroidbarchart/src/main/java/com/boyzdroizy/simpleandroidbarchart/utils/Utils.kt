package com.boyzdroizy.simpleandroidbarchart.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.view.View

object Utils {

    private fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun getLocationOnScreen(v: View): Point {
        val position = IntArray(2)
        v.getLocationOnScreen(position)

        return Point(position[0], position[1] - getStatusBarHeight(v.context))
    }

}