package app

import org.junit.jupiter.api.Test
import placy.App

class AppTest {
  @Test
  fun `main method runs without exceptions`(){
    App.main(emptyArray())
  }

  @Test
  fun `main method runs with wrong arguments`(){
    App.main(arrayOf("bad_argument"))
  }
}