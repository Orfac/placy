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

  private fun thenCategoriesArrayElementsAreFilledWithData() {
    assertTrue(categoriesArray.all(this::isCategoryFilled))
  }

  private fun thenCategoriesArrayNotNull() {
    assertNotNull(categoriesArray)
  }

  private fun whenRetrieveCategories() {
    categoriesArray = categories.getCategories()
  }

  private fun givenDefaultCategories() {
    categories = Categories()
  }

  private fun isCategoryFilled(category: Category): Boolean {
    return category.id != 0 && category.name != "" && category.slug != ""
  }
}