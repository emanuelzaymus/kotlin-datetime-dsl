package datetime.dsl

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalTime
import kotlin.test.assertEquals

@Suppress("ClassName")
internal class `Creation of 12-hour time - Tests` {
    @Nested
    inner class `Should succeed` {
        @Test
        fun `12_00 AM - should return midnight`() {
            val time = 12.00.am
            assertEquals(LocalTime.MIDNIGHT, time)
        }

        @Test
        fun `12_59 AM - should return almost 01_00`() {
            val time = 12.59.am
            assertEquals(LocalTime.of(0, 59), time)
        }

        @Test
        fun `Morning time - should return correct result`() {
            val time = 9.49.am
            assertEquals(LocalTime.of(9, 49), time)
        }

        @Test
        fun `12_00 PM - should return noon`() {
            val time = 12.00.pm
            assertEquals(LocalTime.NOON, time)
        }

        @Test
        fun `12_59 PM - should return almost 13_00`() {
            val time = 12.59.pm
            assertEquals(LocalTime.of(12, 59), time)
        }

        @Test
        fun `Afternoon time - should return correct result`() {
            val time = 5.32.pm
            assertEquals(LocalTime.of(17, 32), time)
        }

        @Test
        fun `11_59 PM - should return almost midnight`() {
            val time = 11.59.pm
            assertEquals(LocalTime.of(23, 59), time)
        }

        @Test
        fun `0 as first digit of minute - should return correct result`() {
            val time = 11.02.am
            assertEquals(LocalTime.of(11, 2), time)
        }

        @Test
        fun `0 as second digit of minute - should return correct result`() {
            val time = 10.30.pm
            assertEquals(LocalTime.of(22, 30), time)
        }
    }

    @Nested
    inner class `Should fail` {
        @Test
        fun `Hour out of valid range, too small hour - should throw exception`() {
            assertThrows<Time12HoursException> { 0.30.am }
            assertThrows<Time12HoursException> { 0.30.pm }
        }

        @Test
        fun `Hour out of valid range, negative - should throw exception`() {
            assertThrows<NegativeTimeException> { (-10.30).am }
            assertThrows<NegativeTimeException> { (-10.30).pm }
        }

        @Test
        fun `Hour out of valid range, too large hour - should throw exception`() {
            assertThrows<Time12HoursException> { (13.22).am }
            assertThrows<Time12HoursException> { (13.22).pm }
        }

        @Test
        fun `Wrong minute format, too small minute - should throw exception`() {
            assertThrows<TimeFormatException> { (6.003).am }
            assertThrows<TimeFormatException> { (6.003).pm }
        }

        @Test
        fun `Wrong minute format, too large minute - should throw exception`() {
            assertThrows<TimeFormatException> { (2.852).am }
            assertThrows<TimeFormatException> { (2.852).pm }
        }
    }
}
