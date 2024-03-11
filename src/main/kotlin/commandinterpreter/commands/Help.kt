package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection

@UsedViaReflection
class Help(cmd: String): AbstractCommand(Regex("help"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        println("Справка по командам")
        println("Добавление телефона: add <Имя> phone <Номер телефона>")
        println("Добавление email: add <Имя> email <Адрес электронной почты>")
        println("Показать последнего добавленного человека: show")
        println("Выход: exit")
    }
}