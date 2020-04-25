package placy.dto



data class City(
  val slug: String = "",
  val name: String = "",
  val timezone: String = "",
  val coords: Coords? = null,
  val language: String = ""
)