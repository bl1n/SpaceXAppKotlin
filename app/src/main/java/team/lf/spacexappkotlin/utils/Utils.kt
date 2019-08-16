package team.lf.spacexappkotlin.utils

import android.content.Context

fun calculateNoOfColumns(context: Context): Int {
    val columnWidthDp = 210f
    val displayMetrics = context.resources.displayMetrics
    val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
    return (screenWidthDp / columnWidthDp + 0.5).toInt()
}