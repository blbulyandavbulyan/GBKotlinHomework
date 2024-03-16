package commandinterpreter.json

class JsonObjectContext: JsonContext {
    private val map: MutableMap<String, Any> = mutableMapOf()
    infix fun String.with(any: Any) {
        map[this]=any
    }
    override fun toString(): String {
        return buildString {
            append("{")
            val entries = map.entries
            val lastIndex = entries.size - 1
            entries.forEachIndexed { index, entry ->
                append("\"${entry.key}\":${entry.value}")
                if (index != lastIndex) append(",")
            }
            append("}")
        }
    }
}