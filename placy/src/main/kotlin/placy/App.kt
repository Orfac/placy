package placy

import placy.console.commands.CategoriesCommand
import placy.console.resolver.CommandResolver
import placy.validation.ArgumentsValidator
import placy.validation.ValidationException

class App {
  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      try {
        ArgumentsValidator().validate(args)
      } catch (ex: ValidationException) {
        printErrorMessage(ex.message)
      }

      val command = CommandResolver().resolve(args.first())
      println(command.execute(args))
    }

    private fun printErrorMessage(message: String?) {
      println("Given arguments are incorrect, Cause - $message \n" +
          "please set them as specified in --help")
    }

  }
}