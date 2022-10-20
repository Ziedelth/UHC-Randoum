package fr.ziedelth.uhcrandoum.listeners.entity

import fr.ziedelth.uhcrandoum.extensions.toItemStack
import fr.ziedelth.uhcrandoum.utils.GameManager
import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ItemSpawnEvent

class ItemSpawn : Listener {
    @EventHandler
    fun onItemSpawn(event: ItemSpawnEvent) {
        val itemStack = event.entity.itemStack

        if (!GameManager.isStarted) return
        if (!Submod.isSubmod(Submod.RANDOM_LOOT)) return

        if (GameManager.drops.contains(itemStack)) {
            GameManager.drops.remove(itemStack)
            return
        }

        val replacedItem = GameManager.materials[itemStack.type]?.toItemStack()
        replacedItem?.let { event.entity.itemStack = it }
    }
}
