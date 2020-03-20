import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import placy.api.Config

class ConfigTest {

  lateinit var requestString: String
  lateinit var response: Response

  @Test
  fun `api request resulted with 200 OK`() {
    givenDefaultUrl()
    whenGetRequested()
    thenReturnsHttpOk()
  }

  private fun thenReturnsHttpOk() {
    assertEquals(200,response.statusCode)
  }

  private fun whenGetRequested() {
    val (_, res, _) = requestString.httpGet().responseString()
    response = res
  }

  private fun givenDefaultUrl() {
    requestString = Config.KUDAGO_URL
  }
}