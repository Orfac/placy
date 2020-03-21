package placy.console.commands

import placy.api.Cities
import placy.validation.ValidationException

class CitiesCommand : Command {
  val citiesApi = Cities

  override fun execute(arguments: Array<String>): String {
    try {
      resolveArguments(arguments)
    } catch (ex : ValidationException){
      return ex.message ?: ""
    }
    val categories = citiesApi.getCities()
    return categories.contentToString()
  }

  private fun resolveArguments(arguments: Array<String>) {
    var index = 1
    while (index < arguments.size){
      val argument = arguments[index]
      when (argument){
        "lang" -> {
          index++
          citiesApi.language = arguments[index]
        }
        "fields" -> {
          index++
          citiesApi.fields = arguments[index].split(",").toTypedArray()
        }
        "order" -> {
          index++
          citiesApi.orderBy = arguments[index]
        }
        else -> {
          throw ValidationException("Unable to validate $argument")
        }
      }
      index++
    }
  }
}