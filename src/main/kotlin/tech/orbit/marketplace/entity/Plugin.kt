package tech.orbit.marketplace.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Plugin(

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    var id: String? = null,

    var fullyQualifiedId: String? = null,
    var url: String? = null,
    var version: String? = null,
    var sinceBuild: String? = null,
    var untilBuild: String? = null
)

data class Plugins(val plugins: List<Plugin>)