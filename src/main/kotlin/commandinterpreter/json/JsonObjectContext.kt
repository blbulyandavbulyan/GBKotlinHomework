package commandinterpreter.json

class JsonObjectContext: JsonContext {
    private val map: MutableMap<String, Any> = mutableMapOf()
    infix fun String.with(any: Any) {
        map[this]=any
    }
    override fun toString(): String {
        return buildString {
            append("{")
            for (entry in map) {
                append("\"${entry.key}\":")
                append(entry.value)
            }
            append("}")
        }
    }
}