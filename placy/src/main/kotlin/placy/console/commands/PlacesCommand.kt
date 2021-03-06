package placy.console.commands

import placy.api.Places
import placy.api.exceptions.ApiException
import placy.dto.requests.PlacesRequest
import placy.console.validation.ValidationException

class PlacesCommand : Command {

  override fun execute(arguments: Array<String>): String {
    val placesRequest: PlacesRequest
    try {
      placesRequest = resolveRequestData(arguments)
    } catch (ex: ValidationException) {
      return ex.message ?: ""
    }

    return try {
      val places = Places().getPlaces(placesRequest)
      return places.contentDeepToString()
    } catch (ex: ApiException) {
      ex.message.toString()
    }

  }

  private fun resolveRequestData(arguments: Array<String>): PlacesRequest {
    var placesRequest = PlacesRequest()

    var index = 0
    while (index < arguments.size) {
      when (val argument = arguments[index]) {
        "lang" -> {
          index++
          placesRequest.language = arguments[index]
        }
        "fields" -> {
          index++
          placesRequest.fields = arguments[index].split(",").toTypedArray()
        }
        "order" -> {
          index++
          placesRequest.orderBy = arguments[index]
        }
        "lon" -> {
          index++
          placesRequest.lon = arguments[index].toDouble()
        }
        "lat" -> {
          index++
          placesRequest.lat = arguments[index].toDouble()
        }
        "radius" -> {
          index++
          placesRequest.radius = arguments[index].toInt()
        }
        "page" -> {
          index++
          placesRequest.page = arguments[index].toInt()
        }
        "page_size" -> {
          index++
          placesRequest.pageSize = arguments[index].toInt()
        }
        "location" -> {
          index++
          placesRequest.location = arguments[index]
        }
        "ids" -> {
          index++
          placesRequest.ids = arguments[index].split(",").toTypedArray()
        }
        "categories" -> {
          index++
          placesRequest.categories = arguments[index].split(",").toTypedArray()
        }

        else -> {
          throw ValidationException("Unable to resolve $argument, please check order of arguments")
        }
      }
      index++
    }
    return placesRequest
  }
}