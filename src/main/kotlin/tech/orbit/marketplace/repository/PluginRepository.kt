package tech.orbit.marketplace.repository

import org.springframework.data.repository.CrudRepository
import tech.orbit.marketplace.entity.Plugin

interface PluginRepository : CrudRepository<Plugin, String> {
}