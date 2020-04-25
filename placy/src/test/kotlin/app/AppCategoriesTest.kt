package app

import org.junit.jupiter.api.Test
import placy.App

class AppCategoriesTest {
  @Test
  fun `main method runs with categories`(){
    App.main(arrayOf("categories"))
  }

  @Test
  fun `main method runs with categories and language`(){
    App.main(arrayOf("categories", "lang", "en"))
  }
  @Test
  fun `main method runs with categories and fields`(){
    App.main(arrayOf("categories", "fields", "id,name"))
  }
  @Test
  fun `main method runs with categories and order`(){
    App.main(arrayOf("categories", "order", "id"))
  }
}