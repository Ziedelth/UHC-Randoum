package fr.ziedelth.uhcrandoum.listeners.player

import fr.ziedelth.uhcrandoum.utils.GameManager
import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class PlayerDropItem : Listener {
    @EventHandler
    fun onPlayerDropItem(event: PlayerDropItemEvent) {
        val player = event.player
        val item = event.itemDrop.itemStack

        if (!GameManager.isStarted) {
            event.isCancelled = true
            return
        }

        if (!Submod.isSubmod(Submod.RANDOM_LOOT)) return

        GameManager.drops.add(item)
    }
}
