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
        println(
            "Given arguments are incorrect, Cause - ${ex.message} \n" +
                "please set them as specified in --help")
      }
      val command = CommandResolver().resolve(args.first())
      println(CategoriesCommand().execute(args))
    }

  }
}