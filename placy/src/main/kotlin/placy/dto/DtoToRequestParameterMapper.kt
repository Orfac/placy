package placy.dto

import placy.dto.requests.PlaceDetailedRequest
import placy.dto.requests.PlacesRequest

class DtoToRequestParameterMapper {
  fun getRequestParameters(placesRequest: PlacesRequest) =
      listOf<Pair<String, Any?>>(
          Pair("lang", placesRequest.language),
          Pair("fields", placesRequest.fields),
          Pair("order_by", placesRequest.orderBy),
          Pair("page", placesRequest.page),
          Pair("page_size", placesRequest.pageSize),
          Pair("location", placesRequest.location),
          Pair("categories", placesRequest.categories),
          Pair("ids", placesRequest.ids),
          Pair("lon", placesRequest.lon),
          Pair("lat", placesRequest.lat),
          Pair("radius", placesRequest.radius)
      )
  fun getRequestParameters(placeDetailedRequest: PlaceDetailedRequest) =
      listOf<Pair<String, Any?>>(
          Pair("lang", placeDetailedRequest.language),
          Pair("fields", placeDetailedRequest.fields),
          Pair("order_by", placeDetailedRequest.place_id)
      )
}