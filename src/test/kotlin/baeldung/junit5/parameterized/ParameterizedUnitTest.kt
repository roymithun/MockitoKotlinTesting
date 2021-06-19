package baeldung.junit5.parameterized

import baeldung.junit5.Complex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

/**
 * source: https://sam09.github.io/Parameterized-Tests-Kotlin/
 */
class ParameterizedUnitTest {
    companion object {
        @JvmStatic
        fun getData(): List<Arguments> {
            return (0..10).map {
                val r1 = Random.nextDouble()
                val r2 = Random.nextDouble()
                val i1 = Random.nextDouble()
                val i2 = Random.nextDouble()
                Arguments.of(Complex(r1, i1), Complex(r2, i2), Complex(r1 + r2, i1 + i2))
            }
        }
    }

    @Test
    fun `verify addition of complex numbers`() {
        val a = Complex(1.0, 2.0)
        val b = Complex(2.0, 4.0)
        val c = Complex(3.0, 6.0)
        val zero = Complex(0.0, 0.0)

        Assertions.assertEquals(c, a + b)
        Assertions.assertEquals(c, b + a)
        Assertions.assertEquals(a, a + zero)
    }

    @ParameterizedTest(name = "{0} + {1} should be {2}")
    @MethodSource("getData")
    fun `Addition works as expected`(a: Complex, b: Complex, c: Complex) {
        val zero = Complex(0.0, 0.0)
        Assertions.assertEquals(c, a + b)
        Assertions.assertEquals(c, b + a)
        Assertions.assertEquals(a, a + zero)
    }
/*
    @ParameterizedTest(name = "{0} + {1} should be {2}")
    @CsvSource(
        "0.6582720559275629, 0.30794612011429257", "0.3803744913139021, 0.08641267464003322", "1.038646547241465, 0.3943587947543258"
//        "0.08870776621968846, 0.7131304276250772, 0.16848272172791257, 0.9373587894807156, 0.257190487947601, 1.6504892171057928",
//        "0.7544034456961829, 0.14147130547639686, 0.6900155625041068, 0.5268555037313022, 1.4444190082002897, 0.668326809207699"
    )
    fun `Addition works as expected with CSV source`(a: Complex, b: Complex, c: Complex) {
        val zero = Complex(0.0, 0.0)
        Assertions.assertEquals(c, a + b)
        Assertions.assertEquals(c, b + a)
        Assertions.assertEquals(a, a + zero)
    }*/
}