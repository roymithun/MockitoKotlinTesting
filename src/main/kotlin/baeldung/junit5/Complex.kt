package baeldung.junit5

/**
 * source: https://sam09.github.io/Parameterized-Tests-Kotlin/
 */
data class Complex(val real: Double, val img: Double) {

    operator fun plus(other: Complex): Complex {
        return Complex(this.real + other.real, this.img + other.img)
    }
}
