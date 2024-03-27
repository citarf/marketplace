package tech.orbit.marketplace.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.orbit.marketplace.service.Plugin
import tech.orbit.marketplace.service.XmlService

@RestController
class PluginController(
    val xmlService: XmlService
) {

    @GetMapping("/plugins")
    fun getPlugins(): List<Plugin> {

        return xmlService.plugins
    }
}