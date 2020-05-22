package placy.placyweb.rest


import org.reactivestreams.Publisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.awaitBody
import placy.placyweb.kudago.KudagoWebClient
import reactor.core.publisher.Mono

@RestController
class DefaultController(private val client : KudagoWebClient) {

  @GetMapping("/")
  fun index() : Publisher<String> {
    return client.get("/places/?page_size=10")
  }
}