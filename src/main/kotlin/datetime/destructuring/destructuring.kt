package datetime.destructuring

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

// LocalDate

/** Returns [LocalDate.getYear]. */
operator fun LocalDate.component1(): Int = year

/** Returns [LocalDate.getMonthValue]. */
operator fun LocalDate.component2(): Int = monthValue

/** Returns [LocalDate.getDayOfMonth]. */
operator fun LocalDate.component3(): Int = dayOfMonth

// LocalTime

/** Returns [LocalTime.getHour]. */
operator fun LocalTime.component1(): Int = hour

/** Returns [LocalTime.getMinute]. */
operator fun LocalTime.component2(): Int = minute

/** Returns [LocalTime.getSecond]. */
operator fun LocalTime.component3(): Int = second

/** Returns [LocalTime.getNano]. */
operator fun LocalTime.component4(): Int = nano

// LocalDateTime

/** Returns [LocalDateTime.getYear]. */
operator fun LocalDateTime.component1(): Int = year

/** Returns [LocalDateTime.getMonthValue]. */
operator fun LocalDateTime.component2(): Int = monthValue

/** Returns [LocalDateTime.getDayOfMonth]. */
operator fun LocalDateTime.component3(): Int = dayOfMonth

/** Returns [LocalDateTime.getHour]. */
operator fun LocalDateTime.component4(): Int = hour

/** Returns [LocalDateTime.getMinute]. */
operator fun LocalDateTime.component5(): Int = minute

/** Returns [LocalDateTime.getSecond]. */
operator fun LocalDateTime.component6(): Int = second

/** Returns [LocalDateTime.getNano]. */
operator fun LocalDateTime.component7(): Int = nano
