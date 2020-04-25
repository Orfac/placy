package placy.console.commands

import placy.console.resolver.CommandResolver
import placy.console.validation.ValidationException

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
    return when (command) {
      is CategoriesCommand -> "Shows existing categories for places\n" +
          "Usage: placy categories [lang value] [fields <values>] [order_by value]\n" +
          "   lang = [en, ru] change categories from russian to english\n " +
          "   fields = [slug, name, id] specify fields to be shown\n" +
          "   order_by = [id, slug, name] specify ordering by field\n"
      is CitiesCommand -> "Shows existing cities for places\n" +
          "Usage: placy cities [lang value] [fields <values>] [order_by value]\n" +
          "   lang = [en, ru] change categories from russian to english\n " +
          "   fields = [slug, name, id] specify fields to be shown, e.g. slug,name\n" +
          "   order_by = [id, slug, name] specify ordering by field\n"
      is HelpCommand -> "Shows help information about command\n" +
          "Usage: placy help command_name\n"
      is PlacesCommand -> "Shows information about group of places\n" +
          "Usage: placy places [attributes values]\n" +
          "Where attributes are:\n" +
          "   lang = [en, ru] change categories from russian to english\n " +
          "   fields = [id, title, slug, address, location, site_url," +
          "     is_closed, phone, timetable, images, description, subway, categories]\n" +
          "     specify fields to be shown, e.g. fields slug,name\n" +
          "   order_by = [id, slug, name] specify ordering by field\n" +
          "   page page_size = paging for minimizing amount of result content, e.g. page 1 page_size 5\n" +
          "   location = [id, slug, name] specify ordering by field\n" +
          "   lon lat radius = data to show places around you, specify your lon, lat and radius e.g. lon 37.6 lat 55.7 radius 900000 \n"
      is PlaceCommand -> "Shows information about place by place id\n" +
          "Usage: placy place place_id [lang value] [fields <values>] [order_by value]\n" +
          "   place_id is required and it is an integer value, e.g. 1\n" +
          "   lang = [en, ru] change categories from russian to english\n" +
          "   fields = [slug, name, id] specify fields to be shown, e.g. fields slug,name\n"
      is DefaultCommand -> "Executes search for 5 places at Saint-Petersburg"
      else -> throw ValidationException("Cannot map command to any of the existing commands")
    }
  }

  private fun getDefaultHelp(): String {
    return "Usage: placy <command> [<args>]\n" +
        "These are placy commands:\n" +
        "   categories      Shows existing categories for places\n" +
        "   cities          Shows existing cities for places\n" +
        "   places          Shows information about group of places\n" +
        "   place           Shows information about place by it's id\n" +
        "   help            Shows help information about command\n\n" +
        "If no command is specified, places command is used\n" +
        "For more information about command use: placy help <command>\n"
  }
}