package placy.console.resolver

import placy.console.commands.CategoriesCommand
import placy.console.commands.CitiesCommand
import placy.console.commands.Command
import placy.console.commands.DefaultCommand
import placy.validation.ValidationException

class CommandResolver {

  companion object Commands {
    const val CITIES = "cities"
    const val CATEGORIES = "categories"
    const val DEFAULT = ""
  }

  fun resolve(commandName : String) : Command{
    return when(commandName) {
      CATEGORIES -> CategoriesCommand()
      CITIES -> CitiesCommand()
      DEFAULT -> DefaultCommand()
      else -> throw ValidationException("Cannot resolve command name")
    }
  }
}