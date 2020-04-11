package placy.dto

data class coords(val lat: Double = 0.0, val lon: Double = 0.0)

data class City(
  val slug: String = "",
  val name: String = "",
  val timezone: String = "",
  val coords: coords? = null,
  val language: String = ""
)