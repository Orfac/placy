package placy

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
    }

  }
}