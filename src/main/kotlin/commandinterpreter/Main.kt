package commandinterpreter

import commandinterpreter.transformer.CommandTransformer
import java.util.Scanner

fun main() {
    val lineReader = LineReader(Scanner(System.`in`))
    val peopleStorage = PeopleStorage()
    val commandTransformer = CommandTransformer()
    println("Наберите help чтобы получить справку по командам")
    while (lineReader.readLine() != "exit") {
        val cmd = lineReader.command
        val command = commandTransformer.transform(cmd)
        command.execute(peopleStorage)
    }
}
fun String?.throwIfNull(): String = this ?: throw RuntimeException()