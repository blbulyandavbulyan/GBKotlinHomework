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
    override fun toString(): String = list.toString()
}