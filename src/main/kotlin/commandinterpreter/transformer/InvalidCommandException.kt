package commandinterpreter.transformer

class InvalidCommandException(cmd: String): RuntimeException("""Command "$cmd" is invalid!""")