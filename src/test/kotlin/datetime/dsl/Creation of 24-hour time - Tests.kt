package datetime.dsl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.*
import java.time.LocalTime

@Suppress("ClassName")
@Nested
internal class `Creation of 24-hour time - Tests` {
    @Nested
    inner class `Should succeed` {
        @Test
        fun `00_00 - should return midnight`() {
            val time = 00.00.time
            assertEquals(LocalTime.MIDNIGHT, time)
        }

        @Test
        fun `(Double) 0 - should return midnight`() {
            val time = 0.toDouble().time
            assertEquals(LocalTime.MIDNIGHT, time)
        }

        @Test
        fun `12_00 - should return noon`() {
            val time = 12.00.time
            assertEquals(LocalTime.NOON, time)
        }

        @Test
        fun `Single-digit hour time - should return correct result`() {
            val time = 9.45.time
            assertEquals(LocalTime.of(9, 45), time)
        }

        @Test
        fun `Double-digit hour time - should return correct result`() {
            val time = 22.15.time
            assertEquals(LocalTime.of(22, 15), time)
        }

        @Test
        fun `0 as first digit of minute - should return correct result`() {
            val time = 15.01.time
            assertEquals(LocalTime.of(15, 1), time)
        }

        @Test
        fun `0 as second digit of minute - should return correct result`() {
            val time = 15.10.time
            assertEquals(LocalTime.of(15, 10), time)
        }

        @Test
        fun `23_59 - should return correct result`() {
            val time = 23.59.time
            assertEquals(LocalTime.of(23, 59), time)
        }
    }

    @Nested
    inner class `Should fail` {
        @Test
        fun `Hour out of valid range, too large hour - should throw exception`() {
            assertThrows<Time24HoursException> { (24.00).time }
        }

        @Test
        fun `Hour out of valid range, negative time - should throw exception`() {
            assertThrows<NegativeTimeException> { (-1.00).time }
        }

        @Test
        fun `Minute out of valid range, too large minute - should throw exception`() {
            assertThrows<TimeMinutesException> { (15.60).time }
        }

        @Test
        fun `Wrong minute format, too small minute - should throw exception`() {
            assertThrows<TimeFormatException> { (15.001).time }
        }

        @Test
        fun `Wrong minute format, too large minute - should throw exception`() {
            assertThrows<TimeFormatException> { (15.789).time }
        }
    }
}
