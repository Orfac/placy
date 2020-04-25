package api

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
    // Given
    val requestString = Config.KUDAGO_URL

    // When
    val (_, response, _) = requestString.httpGet().responseString()

    // Then
    assertEquals(200,response.statusCode)
  }
}