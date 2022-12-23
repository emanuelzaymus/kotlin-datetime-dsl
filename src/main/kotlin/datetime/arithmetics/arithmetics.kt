package datetime.arithmetics

import datetime.dsl.and
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration
import kotlin.time.toJavaDuration

// LocalDate

operator fun LocalDate.plus(duration: Duration): LocalDateTime = atStartOfDay().plus(duration.toJavaDuration())
operator fun LocalDate.minus(duration: Duration): LocalDateTime = atStartOfDay().minus(duration.toJavaDuration())

// LocalTime

operator fun LocalTime.plus(duration: Duration): LocalTime = plus(duration.toJavaDuration())
operator fun LocalTime.minus(duration: Duration): LocalTime = minus(duration.toJavaDuration())

operator fun Double.plus(duration: Duration): LocalTime = and(duration)
operator fun Double.minus(duration: Duration): LocalTime = and(-duration)

// LocalDateTime

operator fun LocalDateTime.plus(duration: Duration): LocalDateTime = plus(duration.toJavaDuration())
operator fun LocalDateTime.minus(duration: Duration): LocalDateTime = minus(duration.toJavaDuration())
