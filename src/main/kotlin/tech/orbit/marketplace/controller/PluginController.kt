package tech.orbit.marketplace.controller

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*
import tech.orbit.marketplace.dto.CreatePluginRequest
import tech.orbit.marketplace.dto.toEntity
import tech.orbit.marketplace.entity.Plugin
import tech.orbit.marketplace.entity.Plugins
import tech.orbit.marketplace.repository.PluginRepository
import tech.orbit.marketplace.service.XmlService

@RestController
@RequestMapping("/plugins")
class PluginController(
    val xmlService: XmlService,
    val pluginRepository: PluginRepository
) {

    @GetMapping
    fun getPlugins(): List<Plugin> {

        return pluginRepository.findAll().toList()
    }

    @PostMapping
    fun savePlugin(@RequestBody plugin: CreatePluginRequest): Plugin {

        val save: Plugin = pluginRepository.save(plugin.toEntity())
        return save
    }

    @GetMapping("/downloadXml")
    fun downloadXml(response: HttpServletResponse) {

        val plugins = Plugins(pluginRepository.findAll().toList())

        val doc = xmlService.generateXml(plugins)
        val xmlString = xmlService.documentToString(doc)

        // Set the content type and headers to indicate a file download
        response.contentType = "application/xml"
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=updatePlugins.xml")

        // Write the XML string to the response's output stream
        response.writer.use { writer ->
            writer.write(xmlString)
            writer.flush()
        }
    }
}

