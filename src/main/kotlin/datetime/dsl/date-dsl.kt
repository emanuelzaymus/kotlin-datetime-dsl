@file:Suppress("FunctionName", "unused")

package datetime.dsl

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth

infix fun Int.January(year: Int) = createLocalDate(this, Month.JANUARY, year)
infix fun Int.February(year: Int) = createLocalDate(this, Month.FEBRUARY, year)
infix fun Int.March(year: Int) = createLocalDate(this, Month.MARCH, year)
infix fun Int.April(year: Int) = createLocalDate(this, Month.APRIL, year)
infix fun Int.May(year: Int) = createLocalDate(this, Month.MAY, year)
infix fun Int.June(year: Int) = createLocalDate(this, Month.JUNE, year)
infix fun Int.July(year: Int) = createLocalDate(this, Month.JULY, year)
infix fun Int.August(year: Int) = createLocalDate(this, Month.AUGUST, year)
infix fun Int.September(year: Int) = createLocalDate(this, Month.SEPTEMBER, year)
infix fun Int.October(year: Int) = createLocalDate(this, Month.OCTOBER, year)
infix fun Int.November(year: Int) = createLocalDate(this, Month.NOVEMBER, year)
infix fun Int.December(year: Int) = createLocalDate(this, Month.DECEMBER, year)

private fun createLocalDate(day: Int, month: Month, year: Int): LocalDate {
    val lengthOfMonth = YearMonth.of(year, month).lengthOfMonth()

    if (day > 0 && day > lengthOfMonth) {
        throw IllegalArgumentException("Day out of bounds")
    }

    return LocalDate.of(year, month, day)
}
