package placy.console.resolver

import placy.console.commands.*
import placy.console.validation.ValidationException

class CommandResolver {

  companion object Commands {
    const val CITIES = "cities"
    const val CATEGORIES = "categories"
    const val HELP = "help"
    const val DEFAULT = ""
    const val PLACES = "places"
    const val PLACE = "place"
    const val COMMENTS = "comments"
  }

  fun resolve(commandName : String) : Command{
    return when(commandName) {
      CATEGORIES -> CategoriesCommand()
      CITIES -> CitiesCommand()
      DEFAULT -> DefaultCommand()
      HELP -> HelpCommand()
      PLACES -> PlacesCommand()
      PLACE -> PlaceCommand()
      COMMENTS -> PlaceCommentsCommand()
      else -> throw ValidationException("Cannot resolve command name $commandName")
    }
  }
}