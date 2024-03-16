package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection
import commandinterpreter.json.JSON
import commandinterpreter.throwIfNull
import java.io.File

@UsedViaReflection
class Export(cmd: String) : AbstractCommand(Regex("export (.+)"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val path = matchGroupCollection[1]?.value.throwIfNull()
        File(path).writeText(JSON.array {
                for (person in peopleStorage) {
                    item {
                        "emails" with person.emails
                        "phones" with person.phones
                        "name" with person.name
                    }
                }
            }.toString())
    }
}