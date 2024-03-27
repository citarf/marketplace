package tech.orbit.marketplace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import tech.orbit.marketplace.service.XmlService

@SpringBootApplication
class MarketplaceApplication

fun main(args: Array<String>) {

    runApplication<MarketplaceApplication>(*args)
}
