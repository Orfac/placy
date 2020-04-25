package app

import org.junit.jupiter.api.Test
import placy.App

class AppCitiesTest {
  @Test
  fun `main method runs with cities`() {
    App.main(arrayOf("cities"))
  }

  @Test
  fun `main method runs with cities and language`() {
    App.main(arrayOf("cities", "lang", "en"))
  }

  @Test
  fun `main method runs with cities and fields`() {
    App.main(arrayOf("cities", "fields", "id,name"))
  }

  @Test
  fun `main method runs with cities and order`() {
    App.main(arrayOf("cities", "order", "id"))
  }
}
