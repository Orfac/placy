package placy.dto.requests

class PlaceDetailedRequest(
  var language: String = "",
  var fields: Array<String> = arrayOf(
      "id", "title", "slug",
      "address", "location", "site_url",
      "is_closed", "phone", "timetable", "images",
      "description", "subway", "categories"),
  var place_id: Int
) : RequestParams {
  override fun toList(): List<Pair<String, Any?>> {
    return listOf<Pair<String, Any?>>(
        Pair("lang", language),
        Pair("fields", fields),
        Pair("place_id", place_id))
  }

}