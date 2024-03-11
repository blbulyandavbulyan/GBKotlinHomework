package commandinterpreter.commands

import commandinterpreter.PeopleStorage

sealed interface Command {
    fun execute(peopleStorage: PeopleStorage)
    fun isValid(): Boolean
}