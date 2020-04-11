package placy.dto.mapper

import placy.dto.requests.PlaceCommentsRequest
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
          Pair("place_id", placeDetailedRequest.place_id)
      )
  fun getRequestParameters(placeCommentsRequest: PlaceCommentsRequest) =
      listOf<Pair<String, Any?>>(
          Pair("lang", placeCommentsRequest.language),
          Pair("fields", placeCommentsRequest.fields),
          Pair("place_id", placeCommentsRequest.place_id),
          Pair("order_by", placeCommentsRequest.orderBy),
          Pair("page", placeCommentsRequest.page),
          Pair("page_size", placeCommentsRequest.page_size),
          Pair("ids", placeCommentsRequest.ids)


      )
}