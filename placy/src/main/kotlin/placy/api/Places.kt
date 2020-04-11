package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.Place

object Places {
  val PLACES_URL = "${Config.KUDAGO_URL}/places/?"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCities(): Array<Place> {
    val requestUrl = PLACES_URL
    val requestParameters = getRequestParameters()
    val result = Fuel.get(requestUrl, requestParameters)
        .responseObject<Array<Place>>().third

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get places from remote url $requestUrl")
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