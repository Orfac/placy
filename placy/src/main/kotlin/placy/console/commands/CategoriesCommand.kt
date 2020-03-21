package placy.console.commands

import placy.api.Categories

class CategoriesCommand : Command {
  val categoriesApi = Categories

  override fun execute(arguments: Array<String>) : String {
    resolveArguments(arguments)
    val categories = categoriesApi.getCategories()
    return categories.contentToString()
  }

  private fun resolveArguments(arguments: Array<String>) {
    for(i in 0..arguments.size){
    }
  }
}