import org.junit.jupiter.api.Test
import placy.App

class AppPlaceCommentsTest {

  @Test
  fun `main method runs with comments`() {
    App.main(arrayOf("comments"))
  }

  @Test
  fun `main method runs with comments by id and could specify language`() {
    App.main(arrayOf("comments", "1", "lang", "en"))
  }

  @Test
  fun `main method runs with comments by id and could specify fields`() {
    App.main(arrayOf("comments", "1", "fields", "id,text"))
  }

  @Test
  fun `main method runs with comments by id using pagination`() {
    App.main(arrayOf("comments", "2", "page", "1", "page_size", "5"))
  }

  @Test
  fun `main method runs with comments by id using ordering`() {
    App.main(arrayOf("comments", "2", "order_by", "text"))
  }


  @Test
  fun `main method runs with comments by id`() {
    App.main(arrayOf("comments", "1"))
  }

}