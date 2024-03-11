package commandinterpreter.commands

import commandinterpreter.PeopleStorage

class Show(cmd: String) : AbstractCommand(Regex("show"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        if(!isValid()) throw RuntimeException("Command is not valid!")
        println(peopleStorage.lastAddedPerson ?: "Not initialized")
    }
}