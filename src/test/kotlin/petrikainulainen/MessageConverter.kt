package petrikainulainen

import petrikainulainen.model.Message
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.converter.ArgumentConversionException
import org.junit.jupiter.params.converter.ArgumentConverter

class MessageConverter : ArgumentConverter {
    override fun convert(source: Any?, context: ParameterContext?): Any {
        checkSource(source)

        return Message(source as String)
    }

    private fun checkSource(source: Any?) {
        if (source == null) {
            throw ArgumentConversionException("Cannot convert null source object")
        }
        if (source !is String) {
            throw ArgumentConversionException("Cannot convert source object because it's not a string")
        }
        val sourceString: String = source
        if (sourceString.trim().isEmpty()) {
            throw  ArgumentConversionException("Cannot convert an empty source string")
        }
    }
}