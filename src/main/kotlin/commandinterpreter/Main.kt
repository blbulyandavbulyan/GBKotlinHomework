package commandinterpreter

import java.util.Scanner

fun main() {
    val lineReader = LineReader(Scanner(System.`in`))
    val peopleInfo = mutableMapOf<String, Person>()
    println("Наберите help чтобы получить справку по командам")
    while (lineReader.readLine() != "exit") {
        val command = lineReader.command
        if (command == "help") {
            println("Справка по командам")
            println("Добавление телефона: add <Имя> phone <Номер телефона>")
            println("Добавление email: add <Имя> email <Адрес электронной почты>")
            println("Выход: exit")
        } else {
            val phoneCommandRegex = Regex("")
            val emailCommandRegex = Regex("")
            //прроверка на сложные команды
            command.matchRegex(phoneCommandRegex) {
                val name = get(1)?.value.throwIfNull()
                val phone = get(2)?.value.throwIfNull()
                peopleInfo.compute(name) { key, value ->
                    Person(key, value?.phone ?: phone, value?.email)
                }
            }.matchAnother(emailCommandRegex) {
                val name = get(1)?.value.throwIfNull()
                val email = get(2)?.value.throwIfNull()
                peopleInfo.compute(name){ key, value ->
                    Person(key, value?.phone, value?.email ?: email)
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