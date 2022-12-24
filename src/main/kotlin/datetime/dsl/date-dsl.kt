@file:Suppress("FunctionName", "unused")

package datetime.dsl

import java.time.LocalDate
import java.time.Month

/** Creates [LocalDate] with [this] dayOfMonth, [Month.JANUARY] and [year]. See [LocalDate.of]. */
infix fun Int.January(year: Int) = createLocalDate(this, Month.JANUARY, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.FEBRUARY] and [year]. See [LocalDate.of]. */
infix fun Int.February(year: Int) = createLocalDate(this, Month.FEBRUARY, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.MARCH] and [year]. See [LocalDate.of]. */
infix fun Int.March(year: Int) = createLocalDate(this, Month.MARCH, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.APRIL] and [year]. See [LocalDate.of]. */
infix fun Int.April(year: Int) = createLocalDate(this, Month.APRIL, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.MAY] and [year]. See [LocalDate.of]. */
infix fun Int.May(year: Int) = createLocalDate(this, Month.MAY, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.JUNE] and [year]. See [LocalDate.of]. */
infix fun Int.June(year: Int) = createLocalDate(this, Month.JUNE, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.JULY] and [year]. See [LocalDate.of]. */
infix fun Int.July(year: Int) = createLocalDate(this, Month.JULY, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.AUGUST] and [year]. See [LocalDate.of]. */
infix fun Int.August(year: Int) = createLocalDate(this, Month.AUGUST, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.SEPTEMBER] and [year]. See [LocalDate.of]. */
infix fun Int.September(year: Int) = createLocalDate(this, Month.SEPTEMBER, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.OCTOBER] and [year]. See [LocalDate.of]. */
infix fun Int.October(year: Int) = createLocalDate(this, Month.OCTOBER, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.NOVEMBER] and [year]. See [LocalDate.of]. */
infix fun Int.November(year: Int) = createLocalDate(this, Month.NOVEMBER, year)

/** Creates [LocalDate] with [this] dayOfMonth, [Month.DECEMBER] and [year]. See [LocalDate.of]. */
infix fun Int.December(year: Int) = createLocalDate(this, Month.DECEMBER, year)

private fun createLocalDate(dayOfMonth: Int, month: Month, year: Int): LocalDate {
    return LocalDate.of(year, month, dayOfMonth)
}
