package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject

import com.github.kittinunf.result.Result;

import placy.dto.Category
import java.lang.StringBuilder

object Categories {
  val CATEGORIES_URL = "${Config.KUDAGO_URL}/place-categories/?"
  var language: String = ""
  var fields: Array<String> = emptyArray()
  var orderBy: String = ""

  fun getCategories(): Array<Category> {
    val requestUrl = buildURL()
    val (_, _, result) = Fuel.get(requestUrl).responseObject<Array<Category>>()

    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get categories from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }

  private fun buildURL(): String {
    val languageArgument = Utils.createArgument(language, "lang")
    val fieldsArgument = Utils.createArraySingleArgument(fields, "fields")
    val orderByFieldsArgument = Utils.createArgument(orderBy, "order_by")
    return CATEGORIES_URL + languageArgument + fieldsArgument + orderByFieldsArgument
  }
}