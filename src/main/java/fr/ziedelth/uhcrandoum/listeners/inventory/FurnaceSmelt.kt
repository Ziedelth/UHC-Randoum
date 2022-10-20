package fr.ziedelth.uhcrandoum.listeners.inventory

import fr.ziedelth.uhcrandoum.extensions.toItemStack
import fr.ziedelth.uhcrandoum.utils.GameManager
import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.FurnaceSmeltEvent

class FurnaceSmelt : Listener {
    @EventHandler
    fun onFurnaceSmelt(event: FurnaceSmeltEvent) {
        val result = event.result ?: return

        if (!Submod.isSubmod(Submod.RANDOM_CRAFT)) return

        val replacedItem = GameManager.materials[result.type]?.toItemStack() ?: return
        event.result = replacedItem
    }
}
