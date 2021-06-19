package vogella

/**
 * source: https://www.vogella.com/tutorials/Mockito/article.html
 */
class Service(private val database: Database) {
    fun query(query: String): Boolean {
        return database.isAvailable()
    }

    override fun toString(): String {
        return "Using database with id: ${database.getUniqueId()}"
    }
}