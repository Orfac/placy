package placy.dto

data class Category(
  var id: Int = 0,
  var slug: String = "",
  var name: String = ""
){

  override fun toString() : String {
    val slugString = if (slug.isEmpty()) "" else "($slug)"
    val idString = if (id == 0) "" else "id=${id}"
    return "$name$slugString $idString"
  }
}