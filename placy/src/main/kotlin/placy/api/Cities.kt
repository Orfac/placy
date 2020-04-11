package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.City

object Cities {
  val CITIES_URL = "${Config.KUDAGO_URL}/locations"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCities(): Array<City> {
    val requestUrl = CITIES_URL
    val params = getRequestParameters()
    val result = Fuel.get(requestUrl, params)
        .responseObject<Array<City>>().third

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get cities from remote url $requestUrl")
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