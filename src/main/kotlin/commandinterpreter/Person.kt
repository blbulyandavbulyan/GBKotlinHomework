package commandinterpreter

class Person(val name: String) {
    val phones: MutableCollection<String> = mutableSetOf()
    val emails: MutableCollection<String> = mutableSetOf()
    override fun toString(): String {
        return "Person(name='$name', phones=$phones, emails=$emails)"
    }
}
