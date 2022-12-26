import datetime.arithmetics.minus
import datetime.arithmetics.plus
import datetime.destructuring.*
import datetime.dsl.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

fun date() {
    val date: LocalDate = 1 February 2000
    println(date) // 2000-02-01
}

fun dateTimeWithoutSecond() {
    val dateTime: LocalDateTime = 23 December 2022 at 10.20
    println(dateTime) // 2022-12-23T10:20
}

fun dateTimeWithSecond() {
    val dateTime: LocalDateTime = 15 March 2023 at 17.40 and 54.seconds
    println(dateTime) // 2023-03-15T17:40:54
}

fun time12() {
    println(12.00.am)                // 00:00
    println(midnight)                // 00:00
    println(01.15.am)                // 01:15
    println(11.59.am and 1.seconds)  // 11:59:01
    println(12.00.pm)                // 12:00
    println(noon)                    // 12:00
    println(midday and 3.seconds)    // 12:00:03
    println(08.44.pm)                // 20:44
    println(11.59.pm and 59.seconds) // 23:59:59
}

fun time24() {
    println(00.00.time)                              // 00:00
    println(10.50.time and 15.seconds)               // 11:50:15
    println(12.00 and 70.seconds and 2.milliseconds) // 12:01:10.002
    println(20.44 and 1.nanoseconds)                 // 20:44:00.000000001
    println(23.59 and 61_009.milliseconds)           // 00:00:01.009
}

fun arithmetics() {
    println((5 May 1999) - 4.days)                               // 1999-05-01T00:00
    println((20 July 2022) + 10.hours + 15.minutes - 50.seconds) // 2022-07-20T10:14:10

    println(00.00 + 5.hours - 2.seconds)           // 04:59:58
    println(10.50 - 40.seconds + 500.microseconds) // 10:49:20.000500

    println(19.20.time + 17.hours + 10.milliseconds)     // 12:20:00.010
    println(19.20.time and 17.hours and 10.milliseconds) // 12:20:00.010
}

fun destructuringDate() {
    val (year, month, day) = LocalDate.of(2022, 12, 31)

    println("Year: $year, Month: $month, Day: $day")
    // Year: 2022, Month: 12, Day: 31
}

fun destructuringTime() {
    val (hour: Int, minute: Int, second: Int, nano: Int) = LocalTime.of(12, 30, 15, 999)

    println("Hour: $hour, Minute: $minute, Second: $second, Nano: $nano")
    // Hour: 12, Minute: 30, Second: 15, Nano: 999
}

fun destructuringDateTime() {
    val (year, month, day, hour, minute, second, nano) = LocalDateTime.of(2022, 12, 23, 10, 20, 54, 1000)

    println("Year: $year, Month: $month, Day: $day, Hour: $hour, Minute: $minute, Second: $second, Nano: $nano")
    // Year: 2022, Month: 12, Day: 23, Hour: 10, Minute: 20, Second: 54, Nano: 1000
}

fun main() {
    date().also { println() }

    dateTimeWithoutSecond().also { println() }

    dateTimeWithSecond().also { println() }

    time12().also { println() }

    time24().also { println() }

    arithmetics().also { println() }

    destructuringDate().also { println() }
    destructuringTime().also { println() }
    destructuringDateTime().also { println() }
}

/**
 * TODO:
 * - comments
 * - readme - examples
 * - public github
 */
