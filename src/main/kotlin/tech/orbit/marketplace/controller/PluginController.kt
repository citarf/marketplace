package tech.orbit.marketplace.controller

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.orbit.marketplace.service.Plugin
import tech.orbit.marketplace.service.Plugins
import tech.orbit.marketplace.service.XmlService

@RestController
class PluginController(
    val xmlService: XmlService
) {

    @GetMapping("/downloadXml")
    fun downloadXml(response: HttpServletResponse) {

        // Example data
        val plugins = Plugins(listOf(
            Plugin("fully.qualified.id.of.this.plugin", "https://mycompany.example.com/my_repo/my_plugin.jar", "major.minor.update", "181.3", "191.*"),
            Plugin("id.of.different.plugin", "https://othercompany.example.com/other_repo/other_plugin.jar", "major.minor","181.3", "191.*")
        ))

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

