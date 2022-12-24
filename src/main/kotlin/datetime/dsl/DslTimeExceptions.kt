package datetime.dsl

/** Exception indicating illegal or wrong argument passed for DSL time creation. */
sealed class DslTimeException(message: String) : IllegalArgumentException(message)

/** Exception indicating wrong time (Double) format. Double should be in format HH.mm */
class TimeFormatException : DslTimeException("Time needs to be in format HH.mm")

/** Exception indicating that Double for DSL time creation was negative. */
class NegativeTimeException : DslTimeException("Time cannot be negative")

/** Exception indicating that hour of 24-hour time was out of bounds. */
class Time24HoursException : DslTimeException("Hour needs to be between 0 and 23")

/** Exception indicating that hour of 12-hour time was out of bounds. */
class Time12HoursException : DslTimeException("Hour needs to be between 1 and 12")

/** Exception indicating that minute of time was out of bounds. */
class TimeMinutesException : DslTimeException("Minute needs to be between 0 and 59")
