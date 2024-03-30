package tech.orbit.marketplace.service

import org.springframework.stereotype.Service
import org.w3c.dom.Document
import org.w3c.dom.Element
import tech.orbit.marketplace.entity.Plugins
import java.io.StringWriter
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

@Service
class XmlService {

    fun generateXml(plugins: Plugins): Document {
        val docFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = docFactory.newDocumentBuilder()

        // Root element <plugins>
        val doc: Document = docBuilder.newDocument()
        val rootElement: Element = doc.createElement("plugins")
        doc.appendChild(rootElement)

        plugins.plugins.forEach { plugin ->
            val pluginElement = doc.createElement("plugin")
            rootElement.appendChild(pluginElement)

            // Set attributes
            pluginElement.setAttribute("id", plugin.fullyQualifiedId)
            pluginElement.setAttribute("url", plugin.url)
            pluginElement.setAttribute("version", plugin.version)

            // Idea version element
            val ideaVersionElement = doc.createElement("idea-version")
            ideaVersionElement.setAttribute("since-build", plugin.sinceBuild)
            ideaVersionElement.setAttribute("until-build", plugin.untilBuild)
            pluginElement.appendChild(ideaVersionElement)
        }

        return doc
    }

    fun documentToString(doc: Document): String {
        val transformer = TransformerFactory.newInstance().newTransformer()
        val source = DOMSource(doc)
        val result = StreamResult(StringWriter())

        transformer.transform(source, result)

        return result.writer.toString()
    }
}