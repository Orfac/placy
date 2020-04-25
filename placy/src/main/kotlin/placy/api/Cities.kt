package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import placy.api.exceptions.ApiException
import placy.dto.City
import placy.dto.requests.DefaultRequestDTO

class Cities {
  val CITIES_URL = "${Config.KUDAGO_URL}/locations"

  fun getCities(requestDTO: DefaultRequestDTO): Array<City> {
    val requestUrl = CITIES_URL
    val params = requestDTO.toList()
    val result = Fuel.get(requestUrl, params).responseObject<Array<City>>().third

    when (result) {
      is Result.Failure -> {
        throw ApiException("Cannot get cities from remote url $requestUrl")
      }
      is Result.Success -> {
        return result.value
      }
    }
  }
}