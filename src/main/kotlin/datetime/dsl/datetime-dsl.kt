@file:Suppress("unused")

package datetime.dsl

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.time.Duration
import kotlin.time.toJavaDuration

/** Combines [this] LocalDate and [time] Double in format HH.mm and returns [LocalDateTime]. See [LocalDate.atTime]. */
infix fun LocalDate.at(time: Double): LocalDateTime {
    val (hour24, minute) = parserAndCheckHour24AndMinute(time)

    return atTime(hour24, minute)
}

/** Combines [this] LocalDate and [localTime] LocalTime and returns [LocalDateTime]. See [LocalDate.atTime]. */
infix fun LocalDate.at(localTime: LocalTime): LocalDateTime = atTime(localTime)

/** Creates 12-hour time [LocalTime] specified by this [Double] in format HH.mm.[am]. See [LocalTime.of]. */
val Double.am: LocalTime
    get() {
        val (hour12, minute) = parseAndCheckHour12AndMinute(time = this)

        return LocalTime.of(if (hour12 == 12) 0 else hour12, minute)
    }

/** Creates 12-hour time [LocalTime] specified by this [Double] in format HH.mm.[pm]. See [LocalTime.of]. */
val Double.pm: LocalTime
    get() {
        val (hour12, minute) = parseAndCheckHour12AndMinute(time = this)

        return LocalTime.of(if (hour12 == 12) 12 else hour12 + 12, minute)
    }

/** Returns [LocalTime.MIDNIGHT]. */
val midnight: LocalTime get() = LocalTime.MIDNIGHT

/** Returns [LocalTime.NOON]. */
val midday: LocalTime get() = LocalTime.NOON

/** Returns [LocalTime.NOON]. */
val noon: LocalTime get() = LocalTime.NOON

/** Creates 24-hour time [LocalTime] specified by this [Double] in format HH.mm.[time]. See [LocalTime.of]. */
val Double.time: LocalTime
    get() {
        val (hour24, minute) = parserAndCheckHour24AndMinute(time = this)

        return LocalTime.of(hour24, minute)
    }

/** Adds [duration] of type [kotlin.time.Duration] to [this] LocalDate and returns new [LocalDateTime]. See [LocalDate.plus]. */
infix fun LocalDate.and(duration: Duration): LocalDateTime = atStartOfDay().plus(duration.toJavaDuration())

/** Adds [duration] of type [kotlin.time.Duration] to [this] LocalTime and returns new [LocalTime]. See [LocalTime.plus]. */
infix fun LocalTime.and(duration: Duration): LocalTime = plus(duration.toJavaDuration())

/** Adds [duration] of type [kotlin.time.Duration] to [this] LocalDateTime and returns new [LocalDateTime]. See [LocalDateTime.plus]. */
infix fun LocalDateTime.and(duration: Duration): LocalDateTime = plus(duration.toJavaDuration())

/** Adds [duration] of type [kotlin.time.Duration] to [this] Double representing 24-hour time in format HH.mm. Returns new [LocalTime]. See [LocalTime.of]. */
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

private fun parseHourAndMinute(time: Double): Pair<Int, Int> {
    if (time < 0) {
        throw NegativeTimeException(time)
    }

    val hour = time.toInt() // Truncate decimals
    val minute = ((time - hour) * 100).roundToInt() // Round properly double to integer

    val shouldBeZero = abs(time - hour - (minute / 100.0))
    if (shouldBeZero > 0.000_000_000_001) {
        throw TimeFormatException(time)
    }

    return hour to minute
}

private fun checkHour24(hour: Int) {
    if (hour !in 0..23) throw Hour24OutOfRangeException(hour)
}

private fun checkHour12(hour: Int) {
    if (hour !in 1..12) throw Hour12OutOfRangeException(hour)
}

private fun checkMinute(minute: Int) {
    if (minute !in 0..59) throw MinuteOutOfRangeException(minute)
}
