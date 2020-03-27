package placy

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

      val commandName = if (args.isNotEmpty()) args.first() else ""
      val command = CommandResolver().resolve(commandName)
      val commandArguments = args.sliceArray(1 until args.size)

      val result = command.execute(commandArguments)
      println(result)
    }

    private fun printErrorMessage(message: String?) {
      println("Given arguments are incorrect, Cause - $message \n" +
          "please set them as specified in --help")
    }

  }
}