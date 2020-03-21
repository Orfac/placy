package placy.console.commands

interface Command {
  fun execute(arguments : Array<String>) : String
}