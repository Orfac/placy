package validation

import org.junit.jupiter.api.Test
import placy.validation.ArgumentsValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.assertThrows
import placy.validation.ValidationException


class ArgumentsValidatorTest {

  lateinit var validator: ArgumentsValidator
  lateinit var arguments: Array<String>

  @Test
  fun `empty arguments pass validation`(){
    givenDefaultValidatorWithEmptyArguments()
    whenValidate()
  }

  @Test
  fun `many arguments don't pass validation`(){
    givenDefaultValidatorWithManyArguments()
    assertThrows(ValidationException::class.java, this :: whenValidate)
  }


  private fun givenDefaultValidatorWithManyArguments() {
    givenDefaultValidator()
    arguments = Array(20){""}
  }

  private fun whenValidate() {
    validator.validate(arguments)
  }

  private fun givenDefaultValidatorWithEmptyArguments() {
    givenDefaultValidator()
    arguments = emptyArray()
  }

  fun givenDefaultValidator(){
    validator = ArgumentsValidator()
  }

}