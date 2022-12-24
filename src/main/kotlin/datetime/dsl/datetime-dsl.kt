@file:Suppress("unused")

package datetime.dsl

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration
import kotlin.time.toJavaDuration

infix fun LocalDate.at(time: Double): LocalDateTime {
    val (hour24, minute) = parserAndCheckHour24AndMinute(time)

    return atTime(hour24, minute)
}

infix fun LocalDate.at(localTime: LocalTime): LocalDateTime = atTime(localTime)

val Double.am: LocalTime
    get() {
        val (hour12, minute) = parseAndCheckHour12AndMinute(this)

        return LocalTime.of(if (hour12 == 12) 0 else hour12, minute)
    }

val Double.pm: LocalTime
    get() {
        val (hour12, minute) = parseAndCheckHour12AndMinute(this)

        return LocalTime.of(if (hour12 == 12) 12 else hour12 + 12, minute)
    }

val midnight: LocalTime get() = LocalTime.MIDNIGHT
val midday: LocalTime get() = LocalTime.NOON
val noon: LocalTime get() = LocalTime.NOON

val Double.time: LocalTime
    get() {
        val (hour24, minute) = parserAndCheckHour24AndMinute(time = this)

        return LocalTime.of(hour24, minute)
    }

infix fun LocalDate.and(duration: Duration): LocalDateTime {
    return atStartOfDay().plus(duration.toJavaDuration())
}

infix fun LocalTime.and(duration: Duration): LocalTime {
    return plus(duration.toJavaDuration())
}

infix fun LocalDateTime.and(duration: Duration): LocalDateTime {
    return plus(duration.toJavaDuration())
}

infix fun Double.and(duration: Duration): LocalTime {
    val (hour24, minute) = parserAndCheckHour24AndMinute(time = this)

    return LocalTime.of(hour24, minute).plus(duration.toJavaDuration())
}

private fun parserAndCheckHour24AndMinute(time: Double): Pair<Int, Int> {
    val (hour, minute) = parseHourAndMinute(time)
    checkHour24(hour)
    checkMinute(minute)

    return hour to minute
}

private fun parseAndCheckHour12AndMinute(time: Double): Pair<Int, Int> {
    val (hour, minute) = parseHourAndMinute(time)
    checkHour12(hour)
    checkMinute(minute)

    return hour to minute
}

// TODO: optimize without strings
private fun parseHourAndMinute(time: Double): Pair<Int, Int> {
    val timeStr = time.toString()

    if ('.' !in timeStr) { // this should not happen in Kotlin
        throw TimeFormatException()
    }

    val (hourStr, minuteStr) = timeStr.split('.')

    if (hourStr.length > 2 || minuteStr.length > 2) {
        throw TimeFormatException()
    }

    val hour = hourStr.toInt()
    if (hour < 0) {
        throw NegativeTimeException()
    }

    val minute = minuteStr.toInt().let { int ->
        if (minuteStr.length == 2 || minuteStr[0] == '0') int
        else int * 10
    }

    return hour to minute
}

private fun checkHour24(hour: Int) {
    if (hour !in 0..23) throw Time24HoursException()
}

private fun checkHour12(hour: Int) {
    if (hour !in 1..12) throw Time12HoursException()
}

private fun checkMinute(minute: Int) {
    if (minute !in 0..59) throw TimeMinutesException()
}
