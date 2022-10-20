package fr.ziedelth.uhcrandoum.listeners.player

import fr.ziedelth.uhcrandoum.extensions.getUHCPlayer
import fr.ziedelth.uhcrandoum.extensions.playSound
import fr.ziedelth.uhcrandoum.extensions.toItemStack
import fr.ziedelth.uhcrandoum.utils.GameManager
import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeath : Listener {
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player = event.entity
        val drops = event.drops

        with(player.getUHCPlayer()) {
            isDead = true
            deathLocation = player.location
        }

        player.killer?.getUHCPlayer()?.kills?.inc()

        playSound(Sound.ENTITY_WITHER_SPAWN)

        // Drops logic
        drops.add(Material.GOLDEN_APPLE.toItemStack())
        if (Submod.isSubmod(Submod.RANDOM_LOOT)) GameManager.drops.addAll(drops)
    }
}