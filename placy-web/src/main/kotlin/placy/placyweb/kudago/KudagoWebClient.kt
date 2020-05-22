package placy.placyweb.kudago

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.*
import reactor.core.publisher.Mono

@Component
class KudagoWebClient() {
  private val client = WebClient.create("https://kudago.com/public-api/v1.4")

  fun get(uri: String): Mono<String> =
      client.get()
          .uri(uri)
          .accept(MediaType.APPLICATION_JSON)
          .retrieve().bodyToMono(String::class.java)
}