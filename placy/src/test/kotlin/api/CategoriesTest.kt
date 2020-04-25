package api

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import placy.api.Categories
import placy.dto.Category
import placy.dto.requests.DefaultRequestDTO

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
    thenCategoriesArrayElementsAreFilledWithData()
  }

  @Test
  fun `categories with russian language could be retrieved`() {
    givenCategoriesWithRussianLanguage()
    whenRetrieveCategories()
    thenCategoriesArrayElementsAreFilledWithData()
  }

  @Test
  fun `categories with english language could be retrieved`() {
    givenCategoriesWithEnglishLanguage()
    whenRetrieveCategories()
    thenCategoriesArrayElementsAreFilledWithData()
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
    thenCategoriesArrayElementsAreFilledWithoutSlug()
  }

  @Test
  fun `categories with ordering by name asc could be retrieved`() {
    givenCategoriesWithOrderingByNameAsc()
    whenRetrieveCategories()
    thenCategoriesArrayNotNull()
  }

  @Test
  fun `categories with ordering by name asc are retrieved with ordering by name`() {
    givenCategoriesWithOrderingByNameAsc()
    whenRetrieveCategories()
    thenCategoriesArrayElementsAreOrderedByNameAsc()
  }

  @Test
  fun `categories with ordering by name desc are retrieved with ordering by id`() {
    givenCategoriesWithOrderingByIdDesc()
    whenRetrieveCategories()
    thenCategoriesArrayElementsAreOrderedByIdDesc()
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
    val categoriesApi = Categories()
    categoriesArray = categoriesApi.getCategories(categoriesRequest)
  }

  private fun thenCategoriesArrayElementsAreOrderedByIdDesc() {
    for (i in 0..categoriesArray.size - 2) {
      assertTrue(
          categoriesArray[i].id > categoriesArray[i + 1].id
      )
    }
  }

  private fun thenCategoriesArrayElementsAreOrderedByNameAsc() {
    for (i in 0..categoriesArray.size - 2) {
      assertTrue(
          categoriesArray[i].name.toLowerCase() < categoriesArray[i + 1].name.toLowerCase()
      )
    }
  }

  private fun thenCategoriesArrayElementsAreFilledWithoutSlug() {
    categoriesArray.all { it.name != "" && it.id != 0 && it.slug == "" }
  }

  private fun thenCategoriesArrayElementsAreFilledWithData() =
      assertTrue(categoriesArray.all(this::isCategoryFullyFilled))

  private fun thenCategoriesArrayNotNull() = assertNotNull(categoriesArray)

  private fun isCategoryFullyFilled(category: Category): Boolean =
      category.id != 0 && category.name != "" && category.slug != ""
}