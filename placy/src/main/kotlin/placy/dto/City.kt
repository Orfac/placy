package placy.dto

data class coords(val lat: Double = 0.0, val lon: Double = 0.0)

data class City(
  val slug: String = "",
  val name: String = "",
  val timezone: String = "",
  val coords: coords? = null,
  val language: String = ""
) {
  override fun toString(): String {
    val slugString = if (slug.isEmpty()) "" else "($slug)"
    val coordsString =
        if (coords?.lat == 0.0 && coords.lon == 0.0) ""
        else "with coords - lon=${coords?.lon} lat=${coords?.lat}"
    val langString = if (language.isEmpty()) "" else "[$language]"
    val timeZoneString = if (timezone.isEmpty()) "" else "@$timezone@"

    return "$name$slugString $coordsString  $langString $timeZoneString"
  }
}