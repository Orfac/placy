package api

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import placy.api.Categories
import placy.dto.Category

class CategoriesTest {

  lateinit var categories: Categories
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

  private fun givenCategoriesWithOrderingByNameAsc() {
    givenDefaultCategories()
    categories.orderBy = "name"
  }

  private fun givenCategoriesWithOrderingByIdDesc() {
    givenDefaultCategories()
    categories.orderBy = "-id"
  }

  private fun thenCategoriesArrayElementsAreFilledWithoutSlug() {
    categoriesArray.all { it.name != "" && it.id != 0 && it.slug == "" }
  }

  private fun givenCategoriesWithNameAndIdFields() {
    givenDefaultCategories()
    categories.fields = arrayOf("name", "id")
  }

  private fun givenCategoriesWithRussianLanguage() {
    givenDefaultCategories()
    categories.language = "ru"
  }

  private fun givenCategoriesWithEnglishLanguage() {
    givenDefaultCategories()
    categories.language = "en"
  }

  private fun thenCategoriesArrayElementsAreFilledWithData() =
      assertTrue(categoriesArray.all(this::isCategoryFullyFilled))

  private fun thenCategoriesArrayNotNull() = assertNotNull(categoriesArray)

  private fun whenRetrieveCategories() {
    categoriesArray = categories.getCategories()
  }

  private fun givenDefaultCategories() {
    categories = Categories
    categories.orderBy = ""
    categories.fields = emptyArray()
    categories.language = ""
  }

  private fun isCategoryFullyFilled(category: Category): Boolean =
      category.id != 0 && category.name != "" && category.slug != ""
}