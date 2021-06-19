package baeldung.mockito

import baeldung.BookService
import baeldung.LendBookManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.lang.IllegalStateException

@ExtendWith(MockitoExtension::class)
class LibraryManagementTest {
    @Mock
    private lateinit var mockBookService: BookService

    @Test
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(false)
        val manager = LendBookManager(mockBookService)
        Assertions.assertThrows(IllegalStateException::class.java) { manager.checkout(100, 1) }
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(true)
        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)
        Mockito.verify(mockBookService).lend(100, 1)
    }

    // https://www.baeldung.com/kotlin/mockito
    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled_kotlin() {
        whenever(mockBookService.inStock(100)).thenReturn(true)
        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)
        verify(mockBookService).lend(100, 1)
    }
}