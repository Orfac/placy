package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.Category
import placy.dto.City

object Cities {
  val CITIES_URL = "${Config.KUDAGO_URL}/locations"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCities(): Array<City> {
    val requestUrl = CITIES_URL
    val params = getParams()
    val (_, _, result) = Fuel.get(requestUrl, params).responseObject<Array<City>>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get cities from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }

  private fun getParams() =
      listOf<Pair<String, Any?>>(
          Pair("lang", language),
          Pair("fields", fields),
          Pair("order_by", orderBy))
}