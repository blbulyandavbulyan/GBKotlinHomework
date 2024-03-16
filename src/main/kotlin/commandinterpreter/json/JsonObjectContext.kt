package commandinterpreter.json

class JsonObjectContext: JsonContext {
    private val map: MutableMap<String, Any> = mutableMapOf()
    infix fun String.with(list: Collection<String>) {
        val jsonArrayContext = JsonArrayContext()
        list.forEach { jsonArrayContext.item(it) }
        map[this] = jsonArrayContext
    }

    infix fun String.with(string: String) {
        map[this]=string
    }

    override fun toString(): String {
        return buildString {
            append("{")
            val entries = map.entries
            val lastIndex = entries.size - 1
            entries.forEachIndexed { index, entry ->
                append("\"${entry.key}\":")
                when (val value = entry.value) {
                    is String -> append("\"$value\"")
                    else -> append(value)
                }
                if (index != lastIndex) append(",")
            }
            append("}")
        }
    }
}