package placy.dto

data class Place(
  var id: String = "",
  var title: String = "",
  var slug: String = "",
  var address: String = "",
  var location: String = "",
  var site_url: String = "",
  var is_closed: String = ""
)