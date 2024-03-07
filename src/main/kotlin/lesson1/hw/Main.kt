package lesson1.hw

import java.util.Scanner

fun main() {
    val commandReader = CommandReader(Scanner(System.`in`))
    val peopleInfo = mutableMapOf<String, PersonInfo>()
    val phoneCommand = Regex("add (.+) phone (.+)")
    val emailCommand = Regex("add (.+) email (.+)")
    println("Наберите help чтобы получить справку по командам")
    while (commandReader.readCommand() != "exit") {
        val command = commandReader.command
        if (command == "help") {
            println("Справка по командам")
            println("Добавление телефона: add <Имя> phone <Номер телефона>")
            println("Добавление email: add <Имя> email <Адрес электронной почты>")
            println("Выход: exit")
        } else {
            //прроверка на сложные команды
            command.matchRegex(phoneCommand) {
                val name = get(1)?.value.throwIfNull()
                val phone = get(2)?.value.throwIfNull()
                peopleInfo.compute(name) { key, value ->
                    PersonInfo(key, value?.phone ?: phone, value?.email)
                }
            }.matchAnother(emailCommand) {
                val name = get(1)?.value.throwIfNull()
                val email = get(2)?.value.throwIfNull()
                peopleInfo.compute(name){ key, value ->
                    PersonInfo(key, value?.phone, value?.email ?: email)
                }
            }
        }
    }
    println(peopleInfo.values)
}

inline fun String.matchRegex(regex: Regex, block: MatchGroupCollection.() -> Unit): Pair<Boolean, String> {
    val let = regex.find(this)?.groups?.let(block)
    return (let != null) to this
}

fun String?.throwIfNull(): String = this ?: throw RuntimeException()

fun Pair<Boolean, String>.matchAnother(regex: Regex, block: MatchGroupCollection.() -> Unit): Pair<Boolean, String> =
    if (!this.first) this.second.matchRegex(regex, block) else this