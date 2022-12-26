package datetime.dsl

/** Exception indicating illegal or wrong argument passed for DSL time creation. */
sealed class DslTimeException(message: String) : IllegalArgumentException(message)

/** Exception indicating wrong time (Double) format. Double should be in format HH.mm */
class TimeFormatException(time: Double) : DslTimeException("Time needs to be in format HH.mm (${time}).")

/** Exception indicating that Double for DSL time creation was negative. */
class NegativeTimeException(time: Double) : DslTimeException("Time cannot be negative ($time).")

/** Exception indicating that hour of 24-hour time was out of bounds. */
class Hour24OutOfRangeException(hour: Int) :
    DslTimeException("Hour of 24-hour time needs to be between 0 and 23 ($hour).")

/** Exception indicating that hour of 12-hour time was out of bounds. */
class Hour12OutOfRangeException(hour: Int) :
    DslTimeException("Hour of 12-hour time needs to be between 1 and 12 ($hour).")

/** Exception indicating that minute of time was out of bounds. */
class MinuteOutOfRangeException(minute: Int) : DslTimeException("Minute needs to be between 0 and 59 ($minute).")
