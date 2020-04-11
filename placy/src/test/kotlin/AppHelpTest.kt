import org.junit.jupiter.api.Test
import placy.App

class AppHelpTest {
  @Test
  fun `main method runs with help command about cities command`(){
    App.main(arrayOf("help", "cities"))
  }
  @Test
  fun `main method runs with help command about categories command`(){
    App.main(arrayOf("help","categories"))
  }
  @Test
  fun `main method runs with help command about places command`(){
    App.main(arrayOf("help", "places"))
  }
  @Test
  fun `main method runs with help command about place command`(){
    App.main(arrayOf("help", "place"))
  }
  @Test
  fun `main method runs with help command about help command`(){
    App.main(arrayOf("help", "help"))
  }

  @Test
  fun `main method runs with help command about default command`(){
    App.main(arrayOf("help", ""))
  }
}