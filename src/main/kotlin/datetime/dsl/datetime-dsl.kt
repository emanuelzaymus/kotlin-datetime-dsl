@file:Suppress("unused")

package datetime.dsl

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

infix fun LocalDate.at(time: Double): LocalDateTime {
    val (hour, minute) = parseHourAndMinute(time)
    checkHour24(hour)
    checkMinute(minute)

    return LocalDateTime.of(year, month, dayOfMonth, hour, minute)
}

infix fun LocalDate.at(localTime: LocalTime): LocalDateTime = LocalDateTime.of(this, localTime)

val Double.am: LocalTime
    get() {
        val (hour, minute) = parseHourAndMinute(this)
        checkHour12(hour)
        checkMinute(minute)
        return LocalTime.of(if (hour == 12) 0 else hour, minute)
    }

val Double.pm: LocalTime
    get() {
        val (hour, minute) = parseHourAndMinute(this)
        checkHour24(hour)
        checkMinute(minute)
        return LocalTime.of(if (hour == 12) 12 else hour + 12, minute)
    }

val midnight: LocalTime get() = LocalTime.of(0, 0)
val midday: LocalTime get() = LocalTime.of(12, 0)
val noon: LocalTime get() = midday

val Double.time: LocalTime
    get() {
        val (hour, minute) = parseHourAndMinute(time = this)
        checkHour24(hour)
        checkMinute(minute)
        return LocalTime.of(hour, minute)
    }

infix fun LocalDateTime.and(duration: Duration): LocalDateTime {
    return plus(duration.toJavaDuration())
}

infix fun LocalDate.and(duration: Duration): LocalDateTime {
    return this.atStartOfDay().plus(duration.toJavaDuration())
}

infix fun Double.and(duration: Duration): LocalTime {
    val (hour, minute) = parseHourAndMinute(time = this)
    return LocalTime.of(hour, minute).plus(duration.toJavaDuration())
}

infix fun LocalTime.and(duration: Duration): LocalTime {
    return plus(duration.toJavaDuration())
}

private fun parseHourAndMinute(time: Double): Pair<Int, Int> {
    val timeStr = time.toString()

    if ('.' !in timeStr) {
        throw IllegalArgumentException("Time needs to be in format HH.mm")
    }

    val (hourStr, minuteStr) = timeStr.split('.')

    if (hourStr.length > 2 || minuteStr.length > 2) {
        throw IllegalArgumentException("Time needs to be in format HH.mm")
    }

    val hour = hourStr.toInt()
    if (hour < 0) {
        throw IllegalArgumentException("Time cannot be negative")
    }

    val minute = minuteStr.toInt().let { int ->
        if (minuteStr.length == 2 || minuteStr[0] == '0') int
        else int * 10
    }

    return hour to minute
}

private fun checkHour24(hour: Int) {
    if (hour !in 0..23) throw IllegalArgumentException("Hour needs to be between 0 and 23")
}

private fun checkHour12(hour: Int) {
    if (hour !in 1..12) throw IllegalArgumentException("Hour needs to be between 1 and 12")
}

private fun checkMinute(minute: Int) {
    if (minute !in 0..59) throw IllegalArgumentException("Minute needs to be between 0 and 59")
}

private fun checkSecond(second: Duration) {
    if (second !in 0.seconds..59.seconds) throw IllegalArgumentException("Second needs to be between 0 and 59")
}
