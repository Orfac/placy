package placy.dto.requests

class PlaceCommentsRequest(
  var language: String = "",
  var fields: Array<String> = arrayOf("id", "text"),
  var place_id: Int,
  var page: Int = 1,
  var page_size: Int = 5,
  var orderBy: String = "",
  var ids: Array<String> = emptyArray()
) : RequestParams {
  override fun toList(): List<Pair<String, Any?>> {
    return listOf<Pair<String, Any?>>(
        Pair("lang", language),
        Pair("fields", fields),
        Pair("place_id", place_id),
        Pair("order_by", orderBy),
        Pair("page", page),
        Pair("page_size", page_size),
        Pair("ids", ids)
    )
  }
}