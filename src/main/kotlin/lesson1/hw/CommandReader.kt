package lesson1.hw

import java.util.Scanner

class CommandReader(private val scanner: Scanner) {
    lateinit var command: String
        private set
    fun readCommand(): String {
        command = scanner.nextLine()
        return command
    }
}