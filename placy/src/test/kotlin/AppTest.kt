import org.junit.jupiter.api.Test
import placy.App

class AppTest {
  @Test
  fun `main method runs without exceptions`(){
    App.main(emptyArray())
  }

  @Test
  fun `main method runs with categories`(){
    App.main(arrayOf("categories"))
  }
}