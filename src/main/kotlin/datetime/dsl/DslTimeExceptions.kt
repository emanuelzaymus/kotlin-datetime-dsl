package datetime.dsl

sealed class DslTimeException(message: String) : IllegalArgumentException(message)

class TimeFormatException : DslTimeException("Time needs to be in format HH.mm")

class NegativeTimeException : DslTimeException("Time cannot be negative")

class Time24HoursException : DslTimeException("Hour needs to be between 0 and 23")

class Time12HoursException : DslTimeException("Hour needs to be between 1 and 12")

class TimeMinutesException : DslTimeException("Minute needs to be between 0 and 59")
