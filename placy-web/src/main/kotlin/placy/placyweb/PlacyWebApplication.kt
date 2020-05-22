package placy.placyweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlacyWebApplication

fun main(args: Array<String>) {
	runApplication<PlacyWebApplication>(*args)
}
