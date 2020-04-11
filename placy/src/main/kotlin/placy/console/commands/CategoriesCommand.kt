package placy.console.commands

import placy.api.Categories
import placy.validation.ValidationException

class CategoriesCommand : Command {
  val categoriesApi = Categories

  override fun execute(arguments: Array<String>) : String {
    try {
      resolveArguments(arguments)
    } catch (ex : ValidationException){
      return ex.message ?: ""
    }
    val categories = categoriesApi.getCategories()
    return categories.contentToString()
  }

  private fun resolveArguments(arguments: Array<String>) {
    var index = 0
    while (index < arguments.size){
      val argument = arguments[index]
      when (argument){
        "lang" -> {
          index++
          categoriesApi.language = arguments[index]
        }
        "fields" -> {
          index++
          categoriesApi.fields = arguments[index].split(",").toTypedArray()
        }
        "order" -> {
          index++
          categoriesApi.orderBy = arguments[index]
        }
        else -> {
          throw ValidationException("Unable to validate ${argument}")
        }
      }
      index++
    }
  }
}