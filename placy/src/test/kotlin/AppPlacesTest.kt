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
  fun `main method runs with places and fields`(){
    App.main(arrayOf("places", "fields", "id,name"))
  }
  @Test
  fun `main method runs with places and order`(){
    App.main(arrayOf("places", "order", "id"))
  }
}