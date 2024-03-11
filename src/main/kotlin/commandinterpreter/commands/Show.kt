package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection
import commandinterpreter.throwIfNull

@UsedViaReflection
class Show(cmd: String) : AbstractCommand(Regex("show (.+)"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val name = matchGroupCollection[1]?.value.throwIfNull()
        println(peopleStorage[name] ?: "Person with name '$name' not found")
    }
}