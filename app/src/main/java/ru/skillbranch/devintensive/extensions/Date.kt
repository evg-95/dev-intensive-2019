package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    this.time += when (units){
        TimeUnits.SECOND->value * SECOND
        TimeUnits.MINUTE->value * MINUTE
        TimeUnits.HOUR->value * HOUR
        TimeUnits.DAY->value * DAY
    }
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun Date.humanizeDiff(): String {
    val diff = Date().time - this.time
    return when (diff) {
        in 0 .. SECOND->"только что"
        in SECOND..45* SECOND->"несколько секунт назад"
        in 45* SECOND..75*SECOND->"минуту назад"
        in 75* SECOND..45* MINUTE->
            "${diff/ MINUTE} ${
            if (diff/MINUTE in 10..20)
                "минут"
            else when((diff/ MINUTE).rem(10).toInt()) {
                1-> "минуту"
                2,3,4-> "минуты"
                else->"минут"
             }} назад"
        in 45* MINUTE ..75* MINUTE-> "час назад"
        in 75* MINUTE..22* HOUR->
            "${diff/ HOUR} ${
            if (diff/HOUR in 10..20)
                "часов"
            else when((diff/ HOUR).rem(10).toInt()) {
                1-> "час"
                2,3,4-> "часа"
                else->"часов"
            }} назад"
        in 22* HOUR..26*HOUR-> "день назад"
        in 26* HOUR..360* DAY->
            "${diff/ DAY} ${
            if (diff/DAY in 10..20) 
                "дней" 
            else when((diff/ DAY).rem(10).toInt()) {
                1-> "день"
                2,3,4-> "дня"
                else->"дней" 
            }} назад"
        else -> "более года назад"
    }

}