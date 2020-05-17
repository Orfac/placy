package api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.ResponseResultOf
import com.github.kittinunf.fuel.core.requests.DefaultRequest
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import placy.api.Categories
import placy.dto.Category
import placy.dto.requests.DefaultRequestDTO
import java.net.URL

@ExtendWith(MockKExtension::class)
class CategoriesTest {

  lateinit var categoriesRequest: DefaultRequestDTO
  lateinit var categoriesArray: Array<Category>


  @Test
  fun `categories could be retrieved`() {
    givenDefaultCategories()
    whenRetrieveCategories()
    thenCategoriesArrayNotNull()
  }

  @Test
  fun `retrieved categories are not empty`() {
    givenDefaultCategories()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories with russian language could be retrieved`() {
    givenCategoriesWithRussianLanguage()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories with english language could be retrieved`() {
    givenCategoriesWithEnglishLanguage()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories with fields name and id could be retrieved`() {
    givenCategoriesWithNameAndIdFields()
    whenRetrieveCategories()
    thenCategoriesArrayNotNull()
  }

  @Test
  fun `categories with fields name and id are retrieved without slug`() {
    givenCategoriesWithNameAndIdFields()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories with ordering by name asc could be retrieved`() {
    givenCategoriesWithOrderingByNameAsc()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories could be retrieved with asc ordering by name`() {
    givenCategoriesWithOrderingByNameAsc()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @Test
  fun `categories could be retrieved with desc ordering by id `() {
    givenCategoriesWithOrderingByIdDesc()
    whenRetrieveCategories()
    thenReturnedCategoriesAreCorrect()
  }

  @BeforeEach
  private fun givenDefaultCategories() {
    categoriesRequest = DefaultRequestDTO()
  }

  private fun givenCategoriesWithOrderingByNameAsc() {
    categoriesRequest.orderBy = "name"
  }

  private fun givenCategoriesWithOrderingByIdDesc() {
    categoriesRequest.orderBy = "-id"
  }

  private fun givenCategoriesWithNameAndIdFields() {
    categoriesRequest.fields = arrayOf("name", "id")
  }

  private fun givenCategoriesWithRussianLanguage() {
    categoriesRequest.language = "ru"
  }

  private fun givenCategoriesWithEnglishLanguage() {
    categoriesRequest.language = "en"
  }

  private fun whenRetrieveCategories() {
    categoriesArray = Categories().getCategories(categoriesRequest)
  }

  private fun thenReturnedCategoriesAreCorrect() {
    assertTrue(categoriesArray.isNotEmpty())
  }

  private fun thenCategoriesArrayNotNull() = assertNotNull(categoriesArray)

}