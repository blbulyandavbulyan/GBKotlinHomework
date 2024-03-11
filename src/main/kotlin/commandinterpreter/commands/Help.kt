package commandinterpreter.commands

import commandinterpreter.PeopleStorage
import commandinterpreter.annotations.UsedViaReflection

@UsedViaReflection
class Help(cmd: String): AbstractCommand(Regex("help"), cmd) {
    override fun execute(peopleStorage: PeopleStorage) {
        println("Справка по командам")
        println("Добавление телефона: add <Имя> phone <Номер телефона>")
        println("Добавление email: add <Имя> email <Адрес электронной почты>")
        println("Показать информацию о человеке: show <Имя>")
        println("Найти человека по телефону или почте: find <АдресИлиТелефон>")
        println("Выход: exit")
    }
}