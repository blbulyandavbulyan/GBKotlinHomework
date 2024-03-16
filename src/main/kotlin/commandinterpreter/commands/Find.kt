package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection
import commandinterpreter.throwIfNull

@UsedViaReflection
class Find(cmd: String): AbstractCommand(Regex("find (.+)"), cmd){
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val emailOrPhone = matchGroupCollection[1]?.value.throwIfNull()
        println(peopleStorage.iterator().asSequence()
            .filter { emailOrPhone in it.emails || emailOrPhone in it.phones }
            .map { it.name }
            .toList())
    }
}