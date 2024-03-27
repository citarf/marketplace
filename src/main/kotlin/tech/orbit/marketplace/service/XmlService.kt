package tech.orbit.marketplace.service

import org.springframework.stereotype.Service
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory

@Service
class XmlService {

    val plugins: List<Plugin> = parse("/Users/pam/IdeaProjects/marketplace/src/main/resources/updatePlugins.xml")

    private fun parse(xmlFile: String): List<Plugin> {
        val xmlDoc: Document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(xmlFile)
        xmlDoc.documentElement.normalize()

        val pluginNodes: NodeList = xmlDoc.getElementsByTagName("plugin")

        val plugins: MutableList<Plugin> = mutableListOf()

        for (i in 0 until pluginNodes.length) {
            val pluginNode: Node = pluginNodes.item(i)
            if (pluginNode.nodeType == Node.ELEMENT_NODE) {

                val pluginElement = pluginNode as Element

                val id = pluginElement.getAttribute("id")
                val url = pluginElement.getAttribute("url")
                val version = pluginElement.getAttribute("version")

                val ideaVersionElement = pluginElement.getElementsByTagName("idea-version").item(0) as Element
                val sinceBuild = ideaVersionElement.getAttribute("since-build")
                val untilBuild = ideaVersionElement.getAttribute("until-build")

                plugins.add(
                        Plugin(id, url, version, sinceBuild, untilBuild)
                )
            }
        }

        return plugins.toList()
    }
}

data class Plugin(
        val id: String,
        val url: String,
        val version: String,
        val sinceBuild: String,
        val untilBuild: String
)