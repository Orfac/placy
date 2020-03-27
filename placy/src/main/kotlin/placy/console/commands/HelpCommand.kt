package placy.console.commands

class HelpCommand : Command {
  override fun execute(arguments: Array<String>): String {
    return if (arguments.isEmpty()){
      "Usage: placy <command> [<args>]" +
          "These are placy commands:" +
          "   categories      Shows existing categories for places\n" +
          "   cities          Shows existing cities for places\n" +
          "   places          Shows places\n\n" +
          "If no command is specified, places command is used"
    } else {
      ""
    }
  }
}