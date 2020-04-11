package placy.dto.requests

data class PlacesRequest(
  var language: String = "",
  var fields: Array<String> = arrayOf(
      "id", "title", "slug",
      "address", "location", "site_url",
      "is_closed", "phone", "timetable", "images",
      "description", "subway", "categories"),
  var orderBy: String = "",
  var page: Int = 1,
  var pageSize: Int = 5,
  var location: String = "spb",
  var categories: Array<String> = emptyArray(),
  var lon: Double = 37.6,
  var lat: Double = 55.7,
  var radius: Int = 900000,
  var ids: Array<String> = emptyArray()
)