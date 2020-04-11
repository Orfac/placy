package placy.console.commands

import placy.api.Places
import placy.dto.requests.PlaceCommentsRequest
import placy.dto.requests.PlaceDetailedRequest
import placy.validation.ValidationException

class PlaceCommentsCommand : Command {
  val placesApi = Places

  override fun execute(arguments: Array<String>): String {
    val placesCommentsRequest: PlaceCommentsRequest
    try {
      placesCommentsRequest = resolveRequestData(arguments)
    } catch (ex: ValidationException) {
      return ex.message ?: ""
    }
    val placesComments = placesApi.getPlacesComments(placesCommentsRequest)
    return placesComments.contentDeepToString()
  }

  private fun resolveRequestData(arguments: Array<String>): PlaceCommentsRequest {

    if (arguments.isEmpty()){
      throw ValidationException("In place command you need to specify at least place id")
    }

    var id: Int = 0
    try {
      id = arguments[0].toInt()
    } catch (ex: NumberFormatException) {
      throw ValidationException("Unable to get place id, given was ${arguments[0]}")
    }
    var placesCommentsRequest = PlaceCommentsRequest(place_id = id)

    var index = 1
    while (index < arguments.size) {
      when (val argument = arguments[index]) {
        "lang" -> {
          index++
          placesCommentsRequest.language = arguments[index]
        }
        "order_by" -> {
          index++
          placesCommentsRequest.orderBy = arguments[index]
        }
        "fields" -> {
          index++
          placesCommentsRequest.fields = arguments[index].split(",").toTypedArray()
        }
        "ids" -> {
          index++
          placesCommentsRequest.ids = arguments[index].split(",").toTypedArray()
        }
        "page" -> {
          index++
          placesCommentsRequest.page = arguments[index].toInt()
        }
        "page_size" -> {
          index++
          placesCommentsRequest.page_size = arguments[index].toInt()
        }

        else -> {
          throw ValidationException("Unable to resolve $argument, please check order of arguments")
        }
      }
      index++
    }
    return placesCommentsRequest
  }
}