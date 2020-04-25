package app

import org.junit.jupiter.api.Test
import placy.App

class AppPlacesTest {
  @Test
  fun `main method runs with places`(){
    App.main(arrayOf("places"))
  }

  @Test
  fun `main method runs with places and language`(){
    App.main(arrayOf("places", "lang", "en"))
  }

  @Test
  fun `main method runs with places using pageable settings`(){
    App.main(arrayOf("places", "page", "1", "page_size", "7"))
  }

  @Test
  fun `main method runs with places and area where to search places`(){
    App.main(arrayOf("places", "lon", "33.7", "lat", "55.7", "radius", "90000000"))
  }


  @Test
  fun `main method runs with places and order`(){
    App.main(arrayOf("places", "order", "id"))
  }
}