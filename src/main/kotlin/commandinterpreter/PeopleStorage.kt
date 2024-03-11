package commandinterpreter

class PeopleStorage: Iterable<Person>{
    private val persons: MutableMap<String, Person> = HashMap()
    var lastAddedPerson: Person? = null
        private set
    operator fun get(name: String): Person? {
        return persons[name]
    }
    fun add(person: Person) {
        val key = person.name
        if (!persons.containsKey(key)) {
            persons[key] = person
            lastAddedPerson = person
        } else throw RuntimeException("Person with this name already exists!")
    }
    fun remove(name: String) {
        persons.remove(name)
    }
    override fun iterator(): Iterator<Person> {
        return persons.values.iterator()
    }
    override fun toString(): String = persons.values.toString()
}