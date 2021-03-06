package placy.console.commands

import placy.api.Cities
import placy.api.exceptions.ApiException
import placy.console.validation.ValidationException
import placy.dto.requests.DefaultRequestDTO

class CitiesCommand : Command {

  override fun execute(arguments: Array<String>): String {
    val citiesRequestData: DefaultRequestDTO
    try {
      citiesRequestData = resolveArguments(arguments)
    } catch (ex: ValidationException) {
      return ex.message.toString()
    }

    return try {
      val cities = Cities().getCities(citiesRequestData)
      cities.contentToString()
    } catch (ex: ApiException) {
      ex.message.toString()
    }
  }

  private fun resolveArguments(arguments: Array<String>): DefaultRequestDTO {
    val requestDTO = DefaultRequestDTO()

    var index = 0
    while (index < arguments.size) {
      when (val argument = arguments[index]) {
        "lang" -> {
          index++
          requestDTO.language = arguments[index]
        }
        "fields" -> {
          index++
          requestDTO.fields = arguments[index].split(",").toTypedArray()
        }
        "order" -> {
          index++
          requestDTO.orderBy = arguments[index]
        }
        else -> {
          throw ValidationException("Unable to validate $argument")
        }
      }
      index++
    }

    return requestDTO
  }
}