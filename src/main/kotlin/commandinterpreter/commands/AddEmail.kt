package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.Person
import commandinterpreter.throwIfNull

class AddEmail(cmd: String): AbstractCommand(Regex("""add (.+) email ([a-zA-Z0-9_!#${'$'}%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+)"""), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val name = matchGroupCollection[1]?.value.throwIfNull()
        val email = matchGroupCollection[2]?.value.throwIfNull()
        peopleStorage[name]?.let { it.email = email } ?: Person(name, null, email)
    }
}