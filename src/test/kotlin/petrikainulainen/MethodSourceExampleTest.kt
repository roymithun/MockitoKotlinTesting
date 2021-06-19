package petrikainulainen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("Should pass the method parameters provided by the sumProvider() method")
class MethodSourceExampleTest {
    companion object {
        @JvmStatic
        fun sumProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(1, 3, 4),
                Arguments.of(2, 5, 7)
            )
        }
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("sumProvider")
    fun `Should calculate the correct sum`(a: Int, b: Int, sum: Int) {
        Assertions.assertEquals(sum, a + b)
    }
}