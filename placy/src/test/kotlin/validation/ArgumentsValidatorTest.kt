package validation

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import placy.console.validation.ArgumentsValidator
import placy.console.validation.ValidationException

class ArgumentsValidatorTest {

  lateinit var validator: ArgumentsValidator
  lateinit var arguments: Array<String>

  @Test
  fun `empty arguments pass validation`() {
    givenWithEmptyArguments()
    whenValidate()
  }

  @Test
  fun `many arguments don't pass validation`() {
    givenWithManyArguments()
    thenThrowsValidationErrorWhenValidating()
  }

  @Test
  fun `wrong commands don't pass validation`() {
    givenWithWrongArguments()
    thenThrowsValidationErrorWhenValidating()
  }

  @Test
  fun `correct command pass validation`() {
    givenWithExistingCommand()
    whenValidate()
  }

  private fun givenWithExistingCommand() {
    arguments = arrayOf("categories")
  }

  private fun thenThrowsValidationErrorWhenValidating() {
    assertThrows(ValidationException::class.java, this::whenValidate)
  }

  @BeforeEach
  fun givenDefaultValidator() {
    validator = ArgumentsValidator()
  }

  private fun givenWithWrongArguments() {
    arguments = arrayOf("wrong-command")
  }

  private fun givenWithManyArguments() {
    arguments = Array(20) { "" }
  }

  private fun whenValidate() {
    validator.validate(arguments)
  }

  private fun givenWithEmptyArguments() {
    arguments = emptyArray()
  }


}