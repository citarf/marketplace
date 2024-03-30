package tech.orbit.marketplace.dto

import tech.orbit.marketplace.entity.Plugin

data class CreatePluginRequest(
    val fullyQualifiedId: String,
    val url: String,
    val version: String,
    val sinceBuild: String,
    val untilBuild: String
)

fun CreatePluginRequest.toEntity(): Plugin {

    return Plugin(
        id= null,
        fullyQualifiedId,
        url,
        version,
        sinceBuild, untilBuild
    )
}