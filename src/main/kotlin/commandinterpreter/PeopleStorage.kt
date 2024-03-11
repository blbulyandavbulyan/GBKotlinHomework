package commandinterpreter

class PeopleStorage{
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
}