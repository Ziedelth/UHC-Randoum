package fr.ziedelth.uhcrandoum.listeners.inventory

import fr.ziedelth.uhcrandoum.extensions.toItemStack
import fr.ziedelth.uhcrandoum.utils.GameManager
import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent

class PrepareItemCraft : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val result = event.inventory.result ?: return

        if (!Submod.isSubmod(Submod.RANDOM_CRAFT)) return

        val replacedItem = GameManager.materials[result.type]?.toItemStack() ?: return
        event.inventory.result = replacedItem
    }
}
