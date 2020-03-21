package placy.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.jackson.responseObject

import com.github.kittinunf.result.Result;

import placy.dto.Category

class Categories {
  val URL = "${Config.KUDAGO_URL}/place-categories/"
  fun getCategories() : Array<Category>{
    val (_,_,result) = Fuel.get(URL).responseObject<Array<Category>>()
    when (result) {
      is Result.Failure -> {
        throw Exception("Cannot get categories from remote url ${URL}")
      }
      is Result.Success -> {
        return result.value
      }
    }

  }
}