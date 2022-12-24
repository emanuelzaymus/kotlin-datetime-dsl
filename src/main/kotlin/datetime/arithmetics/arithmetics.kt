package datetime.arithmetics

import datetime.dsl.and
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration
import kotlin.time.toJavaDuration

// LocalDate

/** Returns [LocalDateTime] from [this] [LocalDate] with specified [duration] added. See [LocalDateTime.plus]. */
operator fun LocalDate.plus(duration: Duration): LocalDateTime = atStartOfDay().plus(duration.toJavaDuration())

/** Returns [LocalDateTime] from [this] [LocalDate] with specified [duration] subtracted. See [LocalDateTime.minus]. */
operator fun LocalDate.minus(duration: Duration): LocalDateTime = atStartOfDay().minus(duration.toJavaDuration())

// LocalTime

/** Returns [LocalTime] from [this] [LocalTime] with specified [duration] added. See [LocalTime.plus]. */
operator fun LocalTime.plus(duration: Duration): LocalTime = plus(duration.toJavaDuration())

/** Returns [LocalTime] from [this] [LocalTime] with specified [duration] subtracted. See [LocalTime.minus]. */
operator fun LocalTime.minus(duration: Duration): LocalTime = minus(duration.toJavaDuration())

/** Returns [LocalTime] from [this] [Double] representing time HH.mm with specified [duration] added. See [Double.and]. */
operator fun Double.plus(duration: Duration): LocalTime = and(duration)

/** Returns [LocalTime] from [this] [Double] representing time HH.mm with specified [duration] subtracted. See [Double.and]. */
operator fun Double.minus(duration: Duration): LocalTime = and(-duration)

// LocalDateTime

/** Returns [LocalDateTime] from [this] [LocalDateTime] with specified [duration] added. See [LocalDateTime.plus]. */
operator fun LocalDateTime.plus(duration: Duration): LocalDateTime = plus(duration.toJavaDuration())

/** Returns [LocalDateTime] from [this] [LocalDateTime] with specified [duration] subtracted. See [LocalDateTime.minus]. */
operator fun LocalDateTime.minus(duration: Duration): LocalDateTime = minus(duration.toJavaDuration())
