package placy.dto.requests

class PlaceCommentsRequest(
  var language: String = "",
  var fields: Array<String> = arrayOf("id", "text"),
  var place_id: Int,
  var page: Int = 1,
  var page_size: Int = 5,
  var orderBy: String = "",
  var ids: Array<String> = emptyArray()

)