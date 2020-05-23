package placy.placyweb

import reactor.core.publisher.Flux
import reactor.netty.ByteBufFlux
import reactor.netty.http.client.HttpClient
import reactor.netty.http.server.HttpServer

class PlacyWebApplication {
  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      val port = 8081

      val client = HttpClient.create()
          .baseUrl("https://kudago.com/public-api/v1.4")

      val server = HttpServer.create()
          .port(port)
          .route { routes ->
            routes.get("/**") { request, response ->
              response
                  .addHeader("Access-Control-Allow-Origin", "*")
                  .addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS")
                  .addHeader(
                      "Access-Control-Allow-Headers",
                      "X-Requested-With, Content-Type, Content-Length")
                  .sendString(
                      client.get()
                          .uri(request.uri())
                          .responseContent()
                          .aggregate()
                          .asString()
                  )
            }
          }
          .bindNow()


      while (true) {
      }
    }
  }
}
