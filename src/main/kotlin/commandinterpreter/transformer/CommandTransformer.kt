package commandinterpreter.transformer

import commandinterpreter.commands.AbstractCommand
import commandinterpreter.commands.Command
import commandinterpreter.commands.Help
import kotlin.reflect.full.primaryConstructor

class CommandTransformer {
    fun transform(cmd: String): Command {
        return AbstractCommand::class.sealedSubclasses.stream()
            .filter { !it.isAbstract }
            .map { it.primaryConstructor?.call(cmd) }
            .map { it as Command }
            .filter { it != null }
            .filter { it.isValid() }
            .findFirst().orElseGet{Help("help")}
    }
}