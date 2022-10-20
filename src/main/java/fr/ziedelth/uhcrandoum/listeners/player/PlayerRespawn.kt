package fr.ziedelth.uhcrandoum.listeners.player

import fr.ziedelth.uhcrandoum.extensions.delay
import fr.ziedelth.uhcrandoum.extensions.getUHCPlayer
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.plugin.Plugin

class PlayerRespawn(private val plugin: Plugin) : Listener {
    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        val player = event.player
        player.getUHCPlayer().deathLocation?.let { event.respawnLocation = it }

        delay(plugin) {
            player.gameMode = GameMode.SPECTATOR
        }
    }
}
