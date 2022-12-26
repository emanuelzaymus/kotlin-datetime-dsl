# kotlin-datetime-dsl

Small **DSL** from creation of **LocalDate**, **LocalTime** and **LocalDateTime** in **Kotlin**.

---

### Traditional date-time creation

```kotlin
val date = LocalDate.of(2022, 12, 31)
val time = LocalTime.of(12, 30, 15, 999)
val dateTime = LocalDateTime.of(2022, 12, 23, 10, 20, 54, 1000)
```

We need to type a lot of numbers in exact order which is error-prone and
not self-explanatory. Modern IDEs like **IntelliJ IDEA** can help us by
showing **hints** pre method parameters. But other IDEs, GitHub or GitLab
won't show us anything.

This projekt presents nice, **safe** and **human-readable** way for creating LocalDate,
LocalTime and LocalDateTime using **extension functions**, **extension properties** and
**infix functions**.

This solution uses build-in extension method on **Int** from Kotlin's **stdlib**
that creat **kotlin.time.Duration**.

---

### LocalDate

```kotlin
val date: LocalDate = 1 February 2000
println(date) // 2000-02-01
```

### LocalDateTime

```kotlin
val dateTime: LocalDateTime = 23 December 2022 at 10.20
println(dateTime) // 2022-12-23T10:20
```

### LocalDateTime with seconds

```kotlin
val dateTime: LocalDateTime = 15 March 2023 at 17.40 and 54.seconds
println(dateTime) // 2023-03-15T17:40:54
```

### Creation of LocalTime in 12-hour time manner

```kotlin
println(12.00.am)                // 00:00
println(midnight)                // 00:00
println(1.15.am)                 // 01:15
println(11.59.am and 1.seconds)  // 11:59:01
println(12.00.pm)                // 12:00
println(noon)                    // 12:00
println(midday and 3.seconds)    // 12:00:03
println(08.44.pm)                // 20:44
println(11.59.pm and 59.seconds) // 23:59:59
```

### Creation of LocalTime in 24-hour time manner

```kotlin
println(00.00.time)                              // 00:00
println(10.50.time and 15.seconds)               // 11:50:15
println(12.00 and 70.seconds and 2.milliseconds) // 12:01:10.002
println(20.44 and 1.nanoseconds)                 // 20:44:00.000000001
println(23.59 and 61_009.milliseconds)           // 00:00:01.009
```

### Safety

Functions throw **custom exceptions** with readable messages when illegal
arguments passed. Functions are unit-tested as well.

```kotlin
0.30.am  // throws datetime.dsl.Hour12OutOfRangeException: Hour of 12-hour time needs to be between 1 and 12 (0).
6.003.pm // throws datetime.dsl.TimeFormatException: Time needs to be in format HH.mm (6.003).

24.00.time   // throws datetime.dsl.Hour24OutOfRangeException: Hour of 24-hour time needs to be between 0 and 23 (24).
(-1.00).time // throws datetime.dsl.NegativeTimeException: Time cannot be negative (-1.0).
15.60.time   // throws datetime.dsl.MinuteOutOfRangeException: Minute needs to be between 0 and 59 (60).
```

### Additional date and time arithmetics

```kotlin
println((5 May 1999) - 4.days)                               // 1999-05-01T00:00
println((20 July 2022) + 10.hours + 15.minutes - 50.seconds) // 2022-07-20T10:14:10

println(00.00 + 5.hours - 2.seconds)           // 04:59:58
println(10.50 - 40.seconds + 500.microseconds) // 10:49:20.000500

println(19.20.time + 17.hours + 10.milliseconds)     // 12:20:00.010
println(19.20.time and 17.hours and 10.milliseconds) // 12:20:00.010
```

### Destructuring declarations

```kotlin
val (year, month, day) = LocalDate.of(2022, 12, 31)
println("Year: $year, Month: $month, Day: $day")
// Year: 2022, Month: 12, Day: 31
```

```kotlin
val (hour, minute, second, nano) = LocalTime.of(12, 30, 15, 999)
println("Hour: $hour, Minute: $minute, Second: $second, Nano: $nano")
// Hour: 12, Minute: 30, Second: 15, Nano: 999
```

```kotlin
val (year, month, day, hour, minute, second, nano) = LocalDateTime.of(2022, 12, 23, 10, 20, 54, 1000)
println("Year: $year, Month: $month, Day: $day, Hour: $hour, Minute: $minute, Second: $second, Nano: $nano")
// Year: 2022, Month: 12, Day: 23, Hour: 10, Minute: 20, Second: 54, Nano: 1000
```

---

### More about date-time in Kotlin

See Kotlin's library: https://github.com/Kotlin/kotlinx-datetime
