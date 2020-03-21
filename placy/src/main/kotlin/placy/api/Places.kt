package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.dto.Category
import placy.dto.City
import placy.dto.Place

object Places {
  val PLACES_URL = "${Config.KUDAGO_URL}/places/?"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCities(): Array<Place> {
    val requestUrl = buildURL()
    val (_, _, result) = Fuel.get(requestUrl).responseObject<Array<Place>>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get cities from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }

  private fun buildURL(): String {
    val languageArgument = Utils.createArgument(Categories.language, "lang")
    val fieldsArgument = Utils.createArraySingleArgument(Categories.fields, "fields")
    val orderByFieldsArgument = Utils.createArgument(Categories.orderBy, "order_by")
    return PLACES_URL + languageArgument + fieldsArgument + orderByFieldsArgument
  }
}