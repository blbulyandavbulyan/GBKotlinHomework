package commandinterpreter.commands

abstract sealed class AbstractCommand(protected val regex: Regex, protected val cmd: String): Command {
    override fun isValid(): Boolean = regex.matches(cmd)
}