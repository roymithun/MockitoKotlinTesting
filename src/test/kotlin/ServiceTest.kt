import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import vogella.Database
import vogella.Service

@ExtendWith(MockitoExtension::class)
class ServiceTest {
//    private val mockDatabase: Database = Mockito.mock(Database::class.java)

    @Mock
    private lateinit var mockDatabase: Database

    @Test
    fun testQuery() {
        Assertions.assertNotNull(mockDatabase)
        Mockito.`when`(mockDatabase.isAvailable()).thenReturn(true)
        val service = Service(mockDatabase)
        val check = service.query("dummy query")
        Assertions.assertTrue(check)
    }
}