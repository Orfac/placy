package placy.console.commands

class DefaultCommand : Command {
  override fun execute(arguments: Array<String>): String {
    return PlacesCommand().execute(arguments)
  }
}