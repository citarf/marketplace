package tech.orbit.marketplace.plugins

import org.springframework.data.repository.CrudRepository

interface PluginRepository : CrudRepository<Plugin, String> {
}