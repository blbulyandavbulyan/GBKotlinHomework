package commandinterpreter.commands

import commandinterpreter.PeopleStorage

class Help(cmd: String): AbstractCommand(Regex("help"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        TODO("Not implemented yet")
    }
}