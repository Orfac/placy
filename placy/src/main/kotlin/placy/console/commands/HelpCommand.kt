package placy.console.commands

import placy.console.resolver.CommandResolver

class HelpCommand : Command {
  override fun execute(arguments: Array<String>): String {
    if (arguments.isEmpty()) {
      return getDefaultHelp()
    } else {
      val commandName = arguments.first()
      val command = CommandResolver().resolve(commandName)

      return getHelpByCommand(command)
    }
  }

  private fun getHelpByCommand(command: Command): String {
    return when(command){
      is CategoriesCommand -> "bla"
      is CitiesCommand -> "bla"
      is HelpCommand -> "bla"
      is DefaultCommand -> "bla"
      else -> ""
    }
  }

  private fun getDefaultHelp(): String {
    return "Usage: placy <command> [<args>]\n" +
        "These are placy commands:\n" +
        "   categories      Shows existing categories for places\n" +
        "   cities          Shows existing cities for places\n" +
        "   places          Shows places\n" +
        "   help            Shows help information about command\n\n" +
        "If no command is specified, places command is used\n" +
        "For more information about command use: placy help <command>\n"
  }
}