package placy.dto.requests

class PlaceDetailedRequest(
  var language: String = "",
  var fields: Array<String> = arrayOf(
      "id", "title", "slug",
      "address", "location", "site_url",
      "is_closed", "phone", "timetable", "images",
      "description", "subway", "categories"),
  var place_id: Int
)