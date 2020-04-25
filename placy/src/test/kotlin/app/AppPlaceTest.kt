package app

import org.junit.jupiter.api.Test
import placy.App

class AppPlaceTest {
  @Test
  fun `main method runs with places`(){
    App.main(arrayOf("place"))
  }

  @Test
  fun `main method runs with place by id and could specify language`(){
    App.main(arrayOf("place", "1", "lang", "en"))
  }
  @Test
  fun `main method runs with place by id and could specify fields`(){
    App.main(arrayOf("place", "1", "fields", "id,name"))
  }
  @Test
  fun `main method runs with place by id`(){
    App.main(arrayOf("place", "1"))
  }
}