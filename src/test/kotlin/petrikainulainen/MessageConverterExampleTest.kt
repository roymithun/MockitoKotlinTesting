package petrikainulainen

import petrikainulainen.model.Message
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource


@DisplayName("Pass converted Message objects to our test method")
class MessageConverterExampleTest {
    @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
    @CsvSource("Hello, Hello", "Hi, Hi")
    fun `Should pass same messages as method parameters`(actual: Message, expected: Message) {
        Assertions.assertEquals(expected.message, actual.message)
    }

    @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
    @CsvSource("Hello, Hello", "Hi, Hi")
    fun `Should pass same messages as method parameters with message converter`(
        @ConvertWith(MessageConverter::class) actual: Message,
        @ConvertWith(MessageConverter::class) expected: Message
    ) {
        Assertions.assertEquals(expected.message, actual.message)
    }
}