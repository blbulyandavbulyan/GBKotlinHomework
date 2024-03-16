package commandinterpreter.json

object JSON {
    fun `object`(init: JsonObjectContext.() -> Unit): JsonObjectContext {
        val jsonObjectContext = JsonObjectContext()
        jsonObjectContext.init()
        return jsonObjectContext
    }

    fun array(init: JsonArrayContext.() -> Unit): JsonArrayContext {
        val jsonArrayContext = JsonArrayContext()
        jsonArrayContext.init()
        return jsonArrayContext
    }
}