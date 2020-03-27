import org.junit.jupiter.api.Test
import placy.App

class AppHelpTest {
  @Test
  fun `main method runs with help command`(){
    App.main(arrayOf("help"))
  }
}