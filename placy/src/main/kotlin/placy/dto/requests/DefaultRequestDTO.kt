package placy.dto.requests

data class DefaultRequestDTO(
  var language: String = "",
  var fields: Array<String> = emptyArray(),
  var orderBy: String = ""
) : RequestParams {
  override fun toList(): List<Pair<String, Any?>> {
    return listOf<Pair<String, Any?>>(
        Pair("lang", this.language),
        Pair("fields", this.fields),
        Pair("order_by", this.orderBy))
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is DefaultRequestDTO) return false

    if (language != other.language) return false
    if (!fields.contentEquals(other.fields)) return false
    if (orderBy != other.orderBy) return false

    return true
  }

  override fun hashCode(): Int {
    var result = language.hashCode()
    result = 31 * result + fields.contentHashCode()
    result = 31 * result + orderBy.hashCode()
    return result
  }
}