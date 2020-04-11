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
    return try{
      val cities = citiesApi.getCities()
      cities.contentToString()
    } catch (ex : Exception){
      ex.message.toString()
    }


  }

  private fun resolveArguments(arguments: Array<String>) {
    var index = 0
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