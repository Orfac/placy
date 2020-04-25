package placy.dto.requests

class DefaultRequestDTO(
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
}