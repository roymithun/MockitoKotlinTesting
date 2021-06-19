package petrikainulainen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

class CsvSourceExampleTest {
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource(
        "1, 2, 3",
        "2, 5, 7",
        "3, 4, 7",
        "10, 3, 13"
    )
    fun `Test correctness of sum of two numbers`(a: Int, b: Int, sum: Int) {
        Assertions.assertEquals(sum, a + b)
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(resources = ["/test-data.csv"])
    fun `Test correctness of sum of two numbers using csv file`(a: Int, b: Int, sum: Int) {
        Assertions.assertEquals(sum, a + b)
    }
}