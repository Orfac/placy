package placy.console.commands

import placy.console.resolver.CommandResolver

class HelpCommand : Command {
  override fun execute(arguments: Array<String>): String {
    return if (arguments.isEmpty()) {
      getDefaultHelp()
    } else {
      val commandName = arguments.first()
      val command = CommandResolver().resolve(commandName)

      getHelpByCommand(command)
    }
  }

  private fun getHelpByCommand(command: Command): String {
    return when(command){
      is CategoriesCommand -> "Shows existing categories for places\n" +
          "Usage: placy categories [lang value] [fields <values>] [order_by value]\n" +
          "   lang = [en, ru] change categories from russian to english\n " +
          "   fields = [slug, name, id] specify fields to be shown\n" +
          "   order_by = [id, slug, name] specify ordering by field\n"
      is CitiesCommand -> "Shows existing cities for places\n" +
          "Usage: placy cities [lang value] [fields <values>] [order_by value]\n" +
          "   lang = [en, ru] change categories from russian to english\n " +
          "   fields = [slug, name, id] specify fields to be shown\n" +
          "   order_by = [id, slug, name] specify ordering by field\n"
      is HelpCommand -> "Shows help information about command\n" +
          "Usage: placy help command_name\n"
      is PlacesCommand -> ""
      is DefaultCommand -> "Executes search for 5 places at Saint-Petersburg"
      else -> throw Exception("Cannot map command to any of the existing commands")
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