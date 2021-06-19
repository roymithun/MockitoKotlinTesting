package petrikainulainen

import baeldung.junit5.CallState
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
class ValueSourceUnitTest {

    @ParameterizedTest(name = "{index} => message = ''{0}''")
    @ValueSource(strings = ["Hello", "World"])
    fun `Should pass non-null message to test method`(message: String) {
        Assertions.assertNotNull(message)
    }

    // this will fail for 3rd input
    @ParameterizedTest(name = "{index} => message = ''{0}''")
    @ValueSource(strings = ["Hello", "World", ""])
    fun `Should pass a non-empty message to test method`(message: String) {
        Assertions.assertTrue(message::isNotEmpty)
    }

    // this will fail for 1st input
    @ParameterizedTest(name = "{index} => callState=''{0}''")
    @EnumSource(CallState::class)
    fun `Should pass only the callState in non-idle state as a method parameter (fail)`(callState: CallState) {
        Assertions.assertTrue(callState::isActive)
    }

    @ParameterizedTest(name = "{index} => callState=''{0}''")
    @EnumSource(value = CallState::class, names = ["INBOUND", "OUTBOUND", "ON_CALL"])
    fun `Should pass only the callState in non-idle state as a method parameter (pass)`(callState: CallState) {
        Assertions.assertTrue(callState::isActive)
    }
}