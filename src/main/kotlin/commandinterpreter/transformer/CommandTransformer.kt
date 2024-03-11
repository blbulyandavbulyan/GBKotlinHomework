package commandinterpreter.transformer

import commandinterpreter.commands.AbstractCommand
import commandinterpreter.commands.Command
import kotlin.reflect.full.primaryConstructor

class CommandTransformer {
    fun transform(cmd: String): Command {
        return AbstractCommand::class.nestedClasses.stream()
            .filter { !it.isAbstract }
            .map { it.primaryConstructor?.call(cmd) }
            .map { it as Command }
            .filter { it != null }
            .filter { it.isValid() }
            .findFirst().orElseThrow { throw InvalidCommandException(cmd) }
    }
}