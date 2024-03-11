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
            .filter { it.containsEmail(emailOrPhone) || it.containsPhone(emailOrPhone) }
            .map { it.name }
            .toList())
    }
}