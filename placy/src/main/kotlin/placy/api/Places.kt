package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.Comment
import placy.dto.Pageable
import placy.dto.Place
import placy.dto.requests.PlaceCommentsRequest
import placy.dto.requests.PlaceDetailedRequest
import placy.dto.requests.PlacesRequest

class Places {
  val PLACES_URL = "${Config.KUDAGO_URL}/places/?"

  fun getPlaces(placesRequest: PlacesRequest): Array<Place> {
    val requestUrl = PLACES_URL
    val requestParameters = placesRequest.toList()
    val (_, _, result) = Fuel.get(requestUrl, requestParameters)
        .responseObject<Pageable<Place>>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get places from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value.results
      }
    }
  }
  fun getPlace(placeDetailedRequest: PlaceDetailedRequest): Place {
    val requestUrl = PLACES_URL
    val requestParameters = placeDetailedRequest.toList()
    val (_, _, result) = Fuel.get(requestUrl, requestParameters)
        .responseObject<Place>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get places from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }

  fun getPlacesComments(placeCommentsRequest: PlaceCommentsRequest) : Array<Comment>{
    val requestUrl = PLACES_URL
    val requestParameters = placeCommentsRequest.toList()
    val (_, _, result) = Fuel.get(requestUrl, requestParameters).responseObject<Pageable<Comment>>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get places from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value.results
      }
    }
  }



}