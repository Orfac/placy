package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.api.exceptions.ApiException
import placy.dto.Category
import placy.dto.requests.DefaultRequestDTO

class Categories {
  val CATEGORIES_URL = "${Config.KUDAGO_URL}/place-categories/?"

  fun getCategories(requestDTO: DefaultRequestDTO): Array<Category> {
    val requestUrl = CATEGORIES_URL
    val requestParameters = requestDTO.toList()
    val result = Fuel.get(requestUrl, requestParameters)
        .responseObject<Array<Category>>().third

    when (result) {
      is Result.Failure -> {
        throw ApiException("Cannot get categories from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }
}