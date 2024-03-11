package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.Person
import commandinterpreter.annotations.UsedViaReflection
import commandinterpreter.throwIfNull

@UsedViaReflection
class AddEmail(cmd: String) :
    AbstractCommand(Regex("""add (.+) email ([a-zA-Z0-9_!#${'$'}%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+)"""), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val name = matchGroupCollection[1]?.value.throwIfNull()
        val email = matchGroupCollection[2]?.value.throwIfNull()
        peopleStorage[name]?.addEmail(email) ?: peopleStorage.add(Person(name).let {
            it.addEmail(email)
            return@let it
        })
    }
}