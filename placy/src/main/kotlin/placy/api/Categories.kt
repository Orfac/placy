package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.Category

object Categories {
  val CATEGORIES_URL = "${Config.KUDAGO_URL}/place-categories/?"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCategories(): Array<Category> {
    val requestUrl = CATEGORIES_URL
    val requestParameters = getRequestParameters()
    val result = Fuel.get(requestUrl, requestParameters)
        .responseObject<Array<Category>>().third

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get categories from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }

  private fun getRequestParameters() =
      listOf<Pair<String, Any?>>(
          Pair("lang", this.language),
          Pair("fields", this.fields),
          Pair("order_by", this.orderBy))
}