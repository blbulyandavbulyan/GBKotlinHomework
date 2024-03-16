package commandinterpreter.json

class JsonArrayContext: JsonContext {
    private val list = mutableListOf<Any>()
    fun item(any: Any) {
        list += any
    }
    fun item(init: JsonObjectContext.()->Unit) {
        val jsonObjectContext = JsonObjectContext()
        jsonObjectContext.init()
        list+=jsonObjectContext
    }
    override fun toString(): String{
        return buildString {
            append("[")
            val lastIndex = list.size - 1
            list.forEachIndexed { index, item->
                when (item) {
                    is String -> append("\"$item\"")
                    else -> append(item)
                }
                if(index != lastIndex)append(",")
            }
            append("]")
        }
    }
}