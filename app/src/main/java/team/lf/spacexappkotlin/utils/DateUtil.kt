package team.lf.spacexappkotlin.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.dateToString(): String {
    val date = Date(this * 1000L)
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(date)
}