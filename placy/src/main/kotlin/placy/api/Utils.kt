package placy.api

internal class Utils {
  companion object {
    fun createArraySingleArgument(argument : Array<String>, argumentName : String) : String{
      return if (argument.isEmpty()) ""
      else "${argumentName}=${argument.joinToString(",")}&"
    }

    fun createArgument(argument : String, argumentName : String) : String{
      return if (argument.isBlank()) ""
      else "${argumentName}=${argument}&"
    }
  }
}