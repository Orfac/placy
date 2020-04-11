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
    return try {
      val place = placesApi.getPlace(placeRequest)
      arrayOf(place).contentDeepToString()
    } catch (ex : Exception) {
      ex.message.toString()
    }

  }

  private fun resolveRequestData(arguments: Array<String>): PlaceDetailedRequest {

    if (arguments.isEmpty()){
      throw ValidationException("In place command you need to specify at least place id")
    }

    var id: Int
    try {
      id = arguments[0].toInt()
    } catch (ex: NumberFormatException) {
      throw ValidationException("Unable to get place id, given was ${arguments[0]}")
    }
    var placeRequest = PlaceDetailedRequest(place_id = id)

    var index = 1
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
