package androvaid

/**
 * source: https://androvaid.com/android/testing-with-mockito/
 */
class Calculator(private val calculatorService: CalculatorService) {
    fun execute(a: Int, b: Int): Int {
        return calculatorService.sum(a, b) * a
    }
}