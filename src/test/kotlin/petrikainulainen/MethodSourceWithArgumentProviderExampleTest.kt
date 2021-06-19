package petrikainulainen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream


@DisplayName("Should pass the method parameters provided by the CustomArgumentProvider class")
class MethodSourceWithArgumentProviderExampleTest {
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @ArgumentsSource(CustomArgumentProvider::class)
    fun `Should calculate the correct sum`(a: Int, b: Int, sum: Int) {
        Assertions.assertEquals(sum, a + b)
    }

    companion object{
        class CustomArgumentProvider : ArgumentsProvider {
            override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
                return Stream.of(
                    Arguments.of(1, 1, 2),
                    Arguments.of(1, 3, 4),
                    Arguments.of(2, 5, 7)
                )
            }

        }
    }
}