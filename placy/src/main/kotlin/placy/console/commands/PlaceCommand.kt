package placy.console.commands

import placy.api.Places
import placy.dto.requests.PlaceDetailedRequest
import placy.dto.requests.PlacesRequest
import placy.validation.ValidationException

class PlaceCommand : Command {
  val placesApi = Places

  override fun execute(arguments: Array<String>): String {
    val placeRequest: PlaceDetailedRequest
    try {
      placeRequest = resolveRequestData(arguments)
    } catch (ex: ValidationException) {
      return ex.message ?: ""
    }
    val place = placesApi.getPlace(placeRequest)
    return arrayOf(place).contentDeepToString()
  }

  private fun resolveRequestData(arguments: Array<String>): PlaceDetailedRequest {
    val id: Int = 0
    try {
      val id = arguments[1].toInt()
    } catch (ex: NumberFormatException) {
      throw ValidationException("Unable to resolve ${arguments[1]}, please check order of arguments")
    }
    var placeRequest = PlaceDetailedRequest(place_id = id)

    var index = 2
    while (index < arguments.size) {
      when (val argument = arguments[index]) {
        "lang" -> {
          index++
          placeRequest.language = arguments[index]
        }
        "fields" -> {
          index++
          placeRequest.fields = arguments[index].split(",").toTypedArray()
        }
        else -> {
          throw ValidationException("Unable to resolve $argument, please check order of arguments")
        }
      }
      index++
    }
    return placeRequest
  }
}
