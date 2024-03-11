package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection

@UsedViaReflection
class ShowAll(cmd: String): AbstractCommand(Regex("show all"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        println(peopleStorage)
    }
}