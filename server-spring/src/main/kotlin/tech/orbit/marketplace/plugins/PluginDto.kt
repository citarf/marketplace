package tech.orbit.marketplace.plugins

data class CreatePluginRequest(
    val fullyQualifiedId: String,
    val name: String,
    val vendor: String,
    val url: String,
    val version: String,
    val sinceBuild: String,
    val untilBuild: String
)

fun CreatePluginRequest.toEntity(): Plugin {

    return Plugin(
        id= null,
        name,
        vendor,
        fullyQualifiedId,
        url,
        version,
        sinceBuild, untilBuild
    )
}