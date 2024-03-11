package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.Person
import commandinterpreter.annotations.UsedViaReflection
import commandinterpreter.throwIfNull
@UsedViaReflection
class AddPhone(cmd: String) : AbstractCommand(
    Regex("""add (.+) phone (\(?\+[0-9]{1,3}\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}(?: ?-?[0-9]{3})? ?(?:\w{1,10}\s?\d{1,6})?)"""),
    cmd
) {
    override fun execute(peopleStorage: PeopleStorage) {
        val matchGroupCollection = regex.find(cmd)?.groups ?: throw RuntimeException("Command is not valid!")
        val name = matchGroupCollection[1]?.value.throwIfNull()
        val phone = matchGroupCollection[2]?.value.throwIfNull()
        peopleStorage[name]?.addPhone(phone) ?: peopleStorage.add(Person(name).let {
            it.addPhone(phone)
            return@let it
        })
    }
}