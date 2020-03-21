package placy.console.resolver

import placy.console.commands.CategoriesCommand
import placy.console.commands.CitiesCommand
import placy.console.commands.Command
import placy.validation.ValidationException

class CommandResolver {
  fun resolve(commandName : String) : Command{
    return when(commandName) {
      "categories" -> CategoriesCommand()
      "cities" -> CitiesCommand()

      else -> throw ValidationException("Cannot resolve command name")
    }
  }
}