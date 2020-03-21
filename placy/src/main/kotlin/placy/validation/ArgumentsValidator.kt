package placy.validation

class ArgumentsValidator {
  companion object {
    fun validate(arguments : Array<String>){
      throw ValidationException("or")
    }
  }
}