package fr.ziedelth.uhcrandoum.listeners

import fr.ziedelth.uhcrandoum.listeners.entity.ItemSpawn
import fr.ziedelth.uhcrandoum.listeners.player.PlayerDeath
import fr.ziedelth.uhcrandoum.listeners.player.PlayerDropItem
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class ListenerManager(private val plugin: Plugin) {
    init {
        val pluginManager = Bukkit.getPluginManager()

        with(pluginManager) {
            registerEvents(PlayerDeath(), plugin)
            registerEvents(ItemSpawn(), plugin)
            registerEvents(PlayerDropItem(), plugin)
        }
    }
}