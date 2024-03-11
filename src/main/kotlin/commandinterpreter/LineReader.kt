package commandinterpreter

import java.util.Scanner

class LineReader(private val scanner: Scanner) {
    lateinit var command: String
        private set
    fun readLine(): String {
        command = scanner.nextLine()
        return command
    }
}