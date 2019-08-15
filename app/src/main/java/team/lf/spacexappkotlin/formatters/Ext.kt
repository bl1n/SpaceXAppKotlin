package team.lf.spacexappkotlin.formatters

import java.text.SimpleDateFormat
import java.util.*

fun dateToString(time: Long): String {
    val date = Date(time * 1000L)
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(date)
}