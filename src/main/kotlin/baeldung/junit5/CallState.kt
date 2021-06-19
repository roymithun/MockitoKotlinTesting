package baeldung.junit5

enum class CallState(private val state: Int) {
    IDLE(0), OUTBOUND(1), INBOUND(2), ON_CALL(3);

    fun isActive(): Boolean {
        return state != IDLE.state
    }
}