package placy.validation

class ArgumentsValidator {
  companion object {
    val validCommandNames : Array<String> = arrayOf("categories", "places","cities")
  }

  fun validate(arguments: Array<String>) {
    if (arguments.isEmpty()) return;

    if (arguments.size > 10)
      throw ValidationException("Too many arguments.")

    val commandName = arguments.first()
    if (!validCommandNames.contains(commandName)){
      throw ValidationException("Wrong command name - ${commandName}.")
    }



  }
}