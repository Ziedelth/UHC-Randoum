package fr.ziedelth.uhcrandoum.listeners

import fr.ziedelth.uhcrandoum.listeners.entity.FoodLevelChange
import fr.ziedelth.uhcrandoum.listeners.entity.ItemSpawn
import fr.ziedelth.uhcrandoum.listeners.inventory.Brew
import fr.ziedelth.uhcrandoum.listeners.inventory.FurnaceSmelt
import fr.ziedelth.uhcrandoum.listeners.inventory.PrepareItemCraft
import fr.ziedelth.uhcrandoum.listeners.player.PlayerDeath
import fr.ziedelth.uhcrandoum.listeners.player.PlayerDropItem
import fr.ziedelth.uhcrandoum.listeners.player.PlayerRespawn
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager

class ListenerManager(private val plugin: Plugin) {
    private fun PluginManager.registerEvents(vararg listeners: Listener) =
        listeners.forEach { registerEvents(it, plugin) }

    init {
        val pluginManager = Bukkit.getPluginManager()

        with(pluginManager) {
            registerEvents(
                PlayerDeath(),
                PlayerRespawn(plugin),
                ItemSpawn(),
                PlayerDropItem(),
                PrepareItemCraft(),
                FurnaceSmelt(),
                Brew(),
                FoodLevelChange(),
            )
        }
    }
}