package placy.console.resolver

import placy.console.commands.*
import placy.validation.ValidationException

class CommandResolver {

  companion object Commands {
    const val CITIES = "cities"
    const val CATEGORIES = "categories"
    const val HELP = "help"
    const val DEFAULT = ""
  }

  fun resolve(commandName : String) : Command{
    return when(commandName) {
      CATEGORIES -> CategoriesCommand()
      CITIES -> CitiesCommand()
      DEFAULT -> DefaultCommand()
      HELP -> HelpCommand()
      else -> throw ValidationException("Cannot resolve command name")
    }
  }
}