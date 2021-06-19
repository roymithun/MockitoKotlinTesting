import androvaid.Calculator
import androvaid.CalculatorService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CalculatorTest {
    @Mock
    private lateinit var calculatorService: CalculatorService

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator(calculatorService)
    }

    @Test
    fun checkSum() {
        Mockito.`when`(calculatorService.sum(2, 2)).thenReturn(4)
        Assertions.assertEquals(8, calculator.execute(2, 2))
        Mockito.verify(calculatorService).sum(2, 2)
    }
}