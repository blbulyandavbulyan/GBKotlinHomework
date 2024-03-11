package commandinterpreter

class PeopleStorage{
    private val persons: MutableMap<String, PersonInfo> = HashMap()
    var lastAddedPerson: PersonInfo? = null
        private set
    operator fun get(name: String): PersonInfo? {
        return persons[name]
    }
    fun add(personInfo: PersonInfo) {
        val key = personInfo.name
        if (!persons.containsKey(key)) {
            persons[key] = personInfo
            lastAddedPerson = personInfo
        } else throw RuntimeException("Person with this name already exists!")
    }
    fun remove(name: String) {
        persons.remove(name)
    }
}